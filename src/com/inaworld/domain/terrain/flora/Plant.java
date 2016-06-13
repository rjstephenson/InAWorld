package com.inaworld.domain.terrain.flora;

import com.inaworld.domain.interfaces.Occupant;

public abstract class Plant implements Occupant {

	@Override
	public boolean isAlive() {
		return true;
	}


	@Override
	public boolean isObtainable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isObstruction() {
		return false;
	}
}
