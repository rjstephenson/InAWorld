package com.inaworld.domain.interfaces;

import com.inaworld.domain.geography.Location;
import com.inaworld.domain.geography.WorldMap;
import com.inaworld.domain.mass.Mass;

public interface Mobile {
	public boolean travel(Location from, Location to, Mass mass, WorldMap WorldMap);
	public int calculateSpeed (int speed);
}
