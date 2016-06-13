package com.inaworld.domain.character.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.didact.issuemanagement.InAWorldException;
import com.inaworld.domain.character.Character2;
import com.inaworld.domain.character.CharacterFactory;

public class PopulationManager {
	List<Character2> census = new ArrayList<Character2>();
	private int populationCount;
	public void populateCensus() throws InAWorldException {
		populationCount = new Random().nextInt(100) + 1;

		for (int i=1; i<populationCount;i++) {
			census.add(CharacterFactory.buildRandomCharacter());
		}
		
	}
	
	public void takeCensus() throws InAWorldException {
//
//		for (Character2 character : census) {
//			System.out.println(character.getAttributes().toString());
//		}
	}
}
