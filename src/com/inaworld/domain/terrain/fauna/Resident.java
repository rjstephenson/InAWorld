package com.inaworld.domain.terrain.fauna;

import com.inaworld.domain.character.Character2;
import com.inaworld.domain.interfaces.Defense;
import com.inaworld.domain.interfaces.Occupant;
import com.inaworld.domain.interfaces.Offense;
import com.inaworld.domain.interfaces.Possession;

public abstract class Resident implements Offense, Defense, Occupant  {

	@Override
	public boolean isAlive() {
		return true;
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
	public boolean isObtainable() {
		return false;
	}

	@Override
	public boolean isObstruction() {
		return true;
	}

}
