package com.battle.platoon.util;

import java.util.Comparator;

import com.battle.platoon.model.Platoon;

public class PlatoonComparator implements Comparator<Platoon> {

	@Override
	public int compare(Platoon o1, Platoon o2) {
		return o1.getSoldierCount()-o2.getSoldierCount();
	}

}
