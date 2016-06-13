package com.inaworld.domain.interfaces;

import com.inaworld.domain.character.Character2;

public interface Offense {
	public void attack(Character2 attacker, Character2 defender, Possession possession);
}
