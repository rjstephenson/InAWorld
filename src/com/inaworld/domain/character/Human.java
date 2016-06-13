package com.inaworld.domain.character;

import com.inaworld.domain.geography.Region;
import com.inaworld.domain.mass.Mass;

public class Human extends Character2 {

	
	public Human() {
		
	}
	
	public Human(Mass mass) {
		super(mass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canOccupyInLocation(Region fromRegion, Region toRegion) {

		return false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
