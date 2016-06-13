package com.inaworld.domain.character;

import com.inaworld.domain.geography.Region;
import com.inaworld.domain.mass.Mass;

public class Zombie extends Character2 {

	
	public Zombie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Zombie(Mass mass) {
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
