package com.battle.platoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.battle.platoon.model.Platoon;
import com.battle.platoon.util.PlatoonComparator;


public class BattleApp {
	public static Map<String, String> advMap;
	static {
		advMap = new HashMap<>();
		advMap.put("Militia", "Spearmen,LightCavalry");
		advMap.put("Spearmen", "LightCavalry,HeavyCavalry");
		advMap.put("LightCavalry", "FootArcherCavalryArcher");
		advMap.put("HeavyCavalry", "Militia,FootArcher,LightCavalry");
		advMap.put("CavalryArcher", "Spearmen,HeavyCavalry");
		advMap.put("FootArcher", "Militia,CavalryArcher");
	}
	public static void main(String[] args) {
		String armyStr=args[0];
		String oppArmyStr=args[1];
		String typeCountSeparator=args[3];
		String platoonSeperator=args[2];
		startBattle(armyStr,oppArmyStr,typeCountSeparator,platoonSeperator);		
	}

	private static void startBattle(String armyStr, String oppArmyStr, String typeCountSeparator,
			String platoonSeperator) {
		String[] armyPlatoons=armyStr.split(platoonSeperator);		
		Map<String, Integer> armyPlatoonsMap = getOurArmyPlatoonsMap(armyPlatoons);
		List<Platoon>  combinations=getALLWinningCombinations(armyStr,oppArmyStr,armyPlatoonsMap);
		String output="";
		int winCount=0;
		for(Platoon finalP:combinations){
			if(finalP.getResultBatch()!=null){
				output=output+finalP.getResultBatch();
				winCount++;
			}else{
				String penidngPlatoon=armyPlatoonsMap.keySet().stream().limit(1).findFirst().get();
				output=output+penidngPlatoon+"#"+armyPlatoonsMap.get(penidngPlatoon)+";";
				if(armyPlatoonsMap.get(penidngPlatoon)>finalP.getSoldierCount()){
					winCount++;
				}
				armyPlatoonsMap.remove(penidngPlatoon);
			}
		}
		System.out.println(output);
		if(winCount<3){
			System.out.println("There is no chance of winning");
		}
		
	}

	private static Map<String, Integer> getOurArmyPlatoonsMap(String[] armyPlatoons) {
		Map<String, Integer> armyPlatoonsMap= new HashMap<>();
		for(int i=0;i<armyPlatoons.length;i++){
			String soldierCount=armyPlatoons[i].split("#")[1];
			String platoonsType=armyPlatoons[i].split("#")[0];
			armyPlatoonsMap.put(platoonsType, Integer.valueOf(soldierCount));
		}
		return armyPlatoonsMap;
	}
	
	public static List<Platoon>  getALLWinningCombinations(String army, String opponentArmy, Map<String, Integer> armyPlatoonsMap){		
		String[] opponenetArmyPlatoons=opponentArmy.split(";");
		String[] armyPlatoons=army.split(";");
		List<Platoon> armyPlatoonList= new ArrayList<Platoon>();
		List<Platoon> opponenetArmyPlatoonsList= new ArrayList<Platoon>();
		armyList(armyPlatoons, armyPlatoonList);
		armyList(opponenetArmyPlatoons, opponenetArmyPlatoonsList);		
		Collections.sort(armyPlatoonList, new PlatoonComparator());
		setExactMatchingArmyPlatoon(armyPlatoonsMap, armyPlatoonList, opponenetArmyPlatoonsList);		
		return opponenetArmyPlatoonsList;		
	}

	private static void setExactMatchingArmyPlatoon(Map<String, Integer> armyPlatoonsMap, List<Platoon> armyPlatoonList,
			List<Platoon> opponenetArmyPlatoonsList) {
		for(Platoon p:armyPlatoonList){
			for(Platoon op:opponenetArmyPlatoonsList){
				if(p.getSoldierCount()>op.getSoldierCount()&&!op.isTaken()){
					op.setTaken(true);
					p.setTaken(true);
					op.setResultBatch(p.getType()+"#"+p.getSoldierCount()+";");
					armyPlatoonsMap.remove(p.getType());
					break;
				}else if(advMap.get(p.getType()).contains(op.getType())&&!op.isTaken()){
					if((p.getSoldierCount()*2)>op.getSoldierCount()){
						op.setTaken(true);
						p.setTaken(true);
						op.setResultBatch(p.getType()+"#"+p.getSoldierCount()+";");
						armyPlatoonsMap.remove(p.getType());
						break;
					}
				}
			}
		}
	}

	private static void armyList(String[] armyPlatoons, List<Platoon> armyPlatoonList) {
		for(int i=0;i<armyPlatoons.length;i++){
			String type=armyPlatoons[i].split("#")[0];
			int count=Integer.valueOf(armyPlatoons[i].split("#")[1]);
			Platoon p=new Platoon();
			p.setType(type);
			p.setSoldierCount(count);
			armyPlatoonList.add(p);
			
		}
	}

}
