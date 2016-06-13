package com.inaworld.domain.armor;

import com.inaworld.domain.character.Character2;
import com.inaworld.domain.interfaces.Defense;
import com.inaworld.domain.interfaces.Offense;
import com.inaworld.domain.interfaces.Possession;
import com.inaworld.domain.possessions.Stuff;

public abstract class Armor extends Stuff implements Defense, Offense {
	int offenseValue;
	int defenseValue;
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
	public void defend(Character2 attacker, Character2 defender, Possession possession) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void attack(Character2 attacker, Character2 defender, Possession possession) {
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
