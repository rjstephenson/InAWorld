package com.inaworld.domain.character;

import java.util.concurrent.Future;

public class CharacterState {
	private Character character;
	private Future<Character> destiny;
	
	public CharacterState(Character character, Future<Character>destiny) {
		this.character = character;
		this.destiny = destiny;
	}
	
	public Character getCharacter() {
		return character;
	}
	public Future<Character> getCharacterDestiny() {
		return destiny;
	}

}
