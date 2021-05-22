package com.battle.platoon.model;

import java.util.Comparator;

public class Platoon implements Comparator<Platoon>{
	private String type;
	private int soldierCount;
	private boolean isTaken;
	private String resultBatch;
	
	public String getResultBatch() {
		return resultBatch;
	}
	public void setResultBatch(String resultBatch) {
		this.resultBatch = resultBatch;
	}
	public boolean isTaken() {
		return isTaken;
	}
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSoldierCount() {
		return soldierCount;
	}
	public void setSoldierCount(int soldierCount) {
		this.soldierCount = soldierCount;
	}
	@Override
	public String toString() {
		return "Platoon [type=" + type + ", soldierCount=" + soldierCount + ", isTaken=" + isTaken + ", resultBatch="
				+ resultBatch + "]";
	}
	@Override
	public int compare(Platoon o1, Platoon o2) {
		return o1.soldierCount-o2.soldierCount;
	}
	
	

}
