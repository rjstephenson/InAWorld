package com.inaworld.domain.character;

import java.util.List;

import com.inaworld.domain.geography.Location;
import com.inaworld.domain.geography.Region;
import com.inaworld.domain.geography.WorldMap;
import com.inaworld.domain.interfaces.Defense;
import com.inaworld.domain.interfaces.Mobile;
import com.inaworld.domain.interfaces.Occupant;
import com.inaworld.domain.interfaces.Offense;
import com.inaworld.domain.interfaces.Possession;
import com.inaworld.domain.mass.Mass;
import com.inaworld.domain.possessions.Stuff;

public abstract class Character2 implements Occupant, Offense, Defense, Mobile, Runnable {

//	private AttributesCache attributes = new AttributesCache();
	private Location location;
	private Mass mass;
	private Region region;
	private List<Stuff> inventory;

	public Character2() {
	}

	public Character2(Mass mass) {
		this.mass = mass;
	}

	@Override
	public boolean isAlive() {
		return true;
	}

	@Override
	public boolean isObtainable() {
		return false;
	}

	@Override
	public boolean isObstruction() {
		return true;
	}

	@Override
	public void defend(Character2 attacker, Character2 defender, Possession possession) {
		// TODO Specifically for hand to hand combat

	}

	@Override
	public void attack(Character2 attacker, Character2 defender, Possession possession) {
		// TODO Specifically for hand to hand combat

	}

	@Override
	public boolean travel(Location from, Location to, Mass mass, WorldMap WorldMap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int calculateSpeed(int speed) {
		// TODO Auto-generated method stub
		return 0;
	}


	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the mass
	 */
	public Mass getMass() {
		return mass;
	}

	/**
	 * @param mass
	 *            the mass to set
	 */
	public void setMass(Mass mass) {
		this.mass = mass;
	}

	/**
	 * @return the inventory
	 */
	public List<Stuff> getInventory() {
		return inventory;
	}

	/**
	 * @param inventory
	 *            the inventory to set
	 */
	public void setInventory(List<Stuff> inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		/**
		 * For character width (left to right) and depth (front to back) are the
		 * same.
		 */
		Location startLocation = new Location(location.getX() - mass.getWidth() / 2, location.getY() - mass.getWidth() / 2, location.getZ());
		Location endLocation = new Location(location.getX() + mass.getWidth() / 2, location.getY() + mass.getWidth() / 2, location.getZ() + mass.getHeightInches() - 1);

		Region region = new Region(startLocation, endLocation);
		return region;
	}
}
