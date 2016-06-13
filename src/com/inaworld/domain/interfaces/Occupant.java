package com.inaworld.domain.interfaces;

import com.inaworld.domain.geography.Region;

public interface Occupant {

	public boolean isAlive ();
	public boolean isObtainable ();
	public boolean isObstruction();
	public boolean canOccupyInLocation(Region fromRegion, Region toRegion);
}
