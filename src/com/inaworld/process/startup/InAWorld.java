package com.inaworld.process.startup;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import pattern.observer.Atmosphere;

import com.inaworld.domain.character.Character;
import com.inaworld.domain.character.CharacterState;
import com.inaworld.domain.character.thread.Randomizer;

public class InAWorld {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		// WorldMap worldMap = new WorldMap(500,500,100);
		// worldMap.setBlock(block, x, y, z);
		// Character2 randy = new Human(new Mass(6,1,36));
		// Map<String, Integer> characterAttrib = new HashMap<String,Integer>();
		//
		// Map<String, AttribDef> attribDefsCache =
		// AttribDefsCache.INSTANCE.getCache();
		// for (String attKey : attribDefsCache.keySet()) {
		// AttribDef att = attribDefsCache.get(attKey);
		// characterAttrib.put(att.getName(), Randomizer.lowToHigh(att.getMin(),
		// att.getMax(), 5));
		// System.out.println(att.getName() + " " +
		// characterAttrib.get(att.getName()));
		// }

		// Meteorology meteorology = new Meteorology();
		// Future<Meteorology> futureWeather =
		// AllPurposePool.INSTANCE.getAllPurposePool().submit(meteorology);
		// Future<Sunlight> futureSunlight =
		// AllPurposePool.INSTANCE.getAllPurposePool().submit(new
		// Sunlight(meteorology));
		String testName = null;
		Map<String, CharacterState> characterStates = new HashMap<String, CharacterState>();

		testName = loadThreadPool(testName, characterStates);
		waitForSeconds(2);
		Atmosphere.INSTANCE.updateOxygen(-50);
		// killCharacter(testName, characterStates);

		testName = loadThreadPool(testName, characterStates);
		testName = loadThreadPool(testName, characterStates);
		waitForSeconds(2);
		
		while (true) {
			System.out.println("*** There are " + characterStates.size() + " characters alive.");
			killCharacter(testName, characterStates);
			waitForSeconds(1);
			
			for (String characterName : characterStates.keySet()) {
				CharacterState oldCharacterState = characterStates.get(characterName);
				System.out.println("Reducing health of " + characterName);
				Character oldCharacter = oldCharacterState.getCharacter();
				int health = (oldCharacter.getCharacterAtribs().get("health"));
				System.out.println(characterName + "'s health is:" + health);
				
				if (health>0) {
					health--;
					Map<String, Integer> newAttrib = new HashMap<String, Integer>();
					newAttrib.put("health", health);
					Character newCharacter = new Character.Builder().name(oldCharacter.getName()).characterAtribs(oldCharacter.getCharacterAtribs(), newAttrib).build();
					Future<Character> destiny = AllPurposePool.INSTANCE.getAllPurposePool().submit(newCharacter);
					CharacterState newCharacterState = new CharacterState(newCharacter, destiny);
					characterStates.put(newCharacter.getName(), newCharacterState);
				} else {
					System.out.println("Trying to remove oldCharacter");
					oldCharacterState.getCharacterDestiny().cancel(true);
					characterStates.remove(oldCharacterState);
				}
			}

			if (characterStates.size() <= 0)  break;
			// if (Randomizer.oneToHigh(22) == 1) {
			// System.out.println("Shutting down the pool.");
			// AllPurposePool.INSTANCE.getAllPurposePool().shutdownNow();
			// }

		}
	}

	/**
	 * @param i
	 * 
	 */
	private static void waitForSeconds(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * @param testName
	 * @param characterStates
	 */
	private static void killCharacter(String testName, Map<String, CharacterState> characterStates) {
		for (String name : characterStates.keySet()) {
			CharacterState characterState = characterStates.get(name);
			// characterState.getCharacter().setEveryLives(false);
			if (Randomizer.oneToHigh(12) == 1) {
				characterState.getCharacterDestiny().cancel(true);
			}
		}

		// Future<Character> futureMan = characterState.getCharacterDestiny();
		// Character man = characterState.getCharacter();
		// man.setEveryLives(false);
		// characterState.getCharacterDestiny().cancel(true);
	}

	//
	// System.out.println("But not any more...");
	// characterState.getCharacterDestiny().cancel(true);
	// try {
	// expiredCharacter = (Character)
	// characterState.getCharacterDestiny().get();
	// } catch (InterruptedException e) {
	// } catch (ExecutionException e) {
	// }
	// System.out.println(expiredCharacter.getName() +
	// " is really dead. I have his carcous here.");
	// System.out.println("His health is " +
	// expiredCharacter.getCharacterAtribs().get("health"));
	// characterThreads.get(oldCharacter.getName()).interrupt();

	/**
	 * @param testName
	 * @param characterStates
	 * @return
	 */
	private static String loadThreadPool(String testName, Map<String, CharacterState> characterStates) {
		for (int i = 1; i <= 1; i++) {
			Character character = new Character.Builder().name().characterAtribs().build();
			Atmosphere.INSTANCE.registerObserver(character);
			Future<Character> destiny = AllPurposePool.INSTANCE.getAllPurposePool().submit(character);
			CharacterState characterState = new CharacterState(character, destiny);
			characterStates.put(character.getName(), characterState);
			testName = character.getName();
		} 
		return testName;
	}

	// int health = oldCharacter.getCharacterAtribs().get("health");
	// health--;
	// Map<String,Integer> newAttrib = new HashMap<String,Integer>();
	// newAttrib.put("health", health);
	// Character newCharacter = new
	// Character.Builder().name(oldCharacter.getName()).characterAtribs(oldCharacter.getCharacterAtribs(),newAttrib).build();
	// characters.remove(characterName);
	// characters.put(newCharacter.getName(),newCharacter);
}
