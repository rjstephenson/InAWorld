package com.inaworld.domain.character;

import com.inaworld.domain.character.thread.Randomizer;

public class CharacterAtrributesFactory {
	final static int normalizer = 5;
	private CharacterAtrributesFactory() {
		// Prevent instantiation
	}

//	public static AttributesCache buildCharacter(CharacterType type) {
//		AttributesCache characterAttributes = null;
//
//		switch (type) {
//		case HUMAN:
//			characterAttributes = buildRandomHumanAttributes();
//			break;
//		case VAMPIRE:
//			characterAttributes = buildRandomHumanAttributes();
//			break;
//		case WEREWOLF:
//			characterAttributes = buildRandomHumanAttributes();
//			break;
//		case ZOMBIE:
//			characterAttributes = buildRandomHumanAttributes();
//			break;
//		}
//		return characterAttributes;
//	}

	/**
	 * 
	 */
//	private static AttributesCache buildRandomHumanAttributes() {
//		AttributesCache characterAttributes = new AttributesCache();
//		characterAttributes.setAge(Randomizer.lowToHigh(8, 90, normalizer));
//		characterAttributes.setCharisma(Randomizer.lowToHigh(4, 24, normalizer));
//		characterAttributes.setDexterity(Randomizer.lowToHigh(4, 24, normalizer));
//		characterAttributes.setEmotionalHealth(Randomizer.lowToHigh(4, 24, normalizer));
//		characterAttributes.setIntelligence(Randomizer.lowToHigh(4, 24, normalizer));
//		characterAttributes.setIntelligence(Randomizer.lowToHigh(4, 24, normalizer));
//		characterAttributes.setLeadership(Randomizer.lowToHigh(4, 24, normalizer));
//		characterAttributes.setName("Test " + Randomizer.lowToHigh(1, 5000));
//		characterAttributes.setPhysicalHealth(Randomizer.lowToHigh(4, 24, normalizer));
//		characterAttributes.setSpeed(Randomizer.lowToHigh(4, 24, normalizer));
//		characterAttributes.setStrength(Randomizer.lowToHigh(4, 24, normalizer));
//		return characterAttributes;
//	}

}
