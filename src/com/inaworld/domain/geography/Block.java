package com.inaworld.domain.geography;

import java.util.List;

import com.inaworld.domain.interfaces.Matter;
import com.inaworld.domain.interfaces.Occupant;

public abstract class Block implements Matter {
	String baseColor; 
	String currentColor;
	List<Occupant> occupants;
	/**
	 * @return the baseColor
	 */
	public String getBaseColor() {
		return baseColor;
	}
	/**
	 * @param baseColor the baseColor to set
	 */
	public void setBaseColor(String baseColor) {
		this.baseColor = baseColor;
	}
	/**
	 * @return the currentColor
	 */
	public String getCurrentColor() {
		return currentColor;
	}
	/**
	 * @param currentColor the currentColor to set
	 */
	public void setCurrentColor(String currentColor) {
		this.currentColor = currentColor;
	}
	/**
	 * @return the occupants
	 */
	public List<Occupant> getOccupants() {
		return occupants;
	}
	/**
	 * @param occupants the occupants to set
	 */
	public void setOccupants(List<Occupant> occupants) {
		this.occupants = occupants;
	}


}
