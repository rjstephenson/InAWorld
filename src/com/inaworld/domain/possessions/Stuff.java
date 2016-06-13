package com.inaworld.domain.possessions;

import com.inaworld.domain.character.Character2;
import com.inaworld.domain.interfaces.Occupant;
import com.inaworld.domain.interfaces.Possession;

public abstract class Stuff implements Possession, Occupant {
	String name;
	String description;
	int weight;
	int value;
	Character2 possessor;
	
	@Override
	public void pickup() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void discard() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sell() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void buy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isAlive() {
		return false;
	}

	@Override
	public boolean isObtainable() {
		return true;
	}
	@Override
	public boolean isObstruction() {
		return false;
	} 
}
