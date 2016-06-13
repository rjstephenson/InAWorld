package com.inaworld.domain.character;

import com.inaworld.domain.character.thread.Randomizer;

public class CharacterFactory {

	private CharacterFactory() {
		// Prevent instantiation
	}

	public static Character2 buildCharacter(CharacterType type) {
		Character2 character = null;

		switch (type) {
		case HUMAN:
			character = new Human();
//			character.setAttributes(CharacterAtrributesFactory.buildCharacter(CharacterType.HUMAN));
			break;
		case VAMPIRE:
			character = new Vampire();
//			character.setAttributes(CharacterAtrributesFactory.buildCharacter(CharacterType.VAMPIRE));
			break;
		case WEREWOLF:
			character = new Werewolf();
//			character.setAttributes(CharacterAtrributesFactory.buildCharacter(CharacterType.WEREWOLF));
			break;
		case ZOMBIE:
			character = new Zombie();	
//			character.setAttributes(CharacterAtrributesFactory.buildCharacter(CharacterType.ZOMBIE));
			break;
		}
		return character;
	}

	public static Character2 buildRandomCharacter() {
		Randomizer.lowToHigh(1, 4);

		Character2 character = null;

		switch (Randomizer.lowToHigh(1, 4)) {
		case 1:
			character = buildCharacter(CharacterType.HUMAN);
			break;
		case 2:
			character = buildCharacter(CharacterType.VAMPIRE);
			break;
		case 3:
			character = buildCharacter(CharacterType.WEREWOLF);
			break;
		case 4:
			character = buildCharacter(CharacterType.ZOMBIE);
			break;
		}
		return character;
	}
}
