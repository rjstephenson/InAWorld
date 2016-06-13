package com.inaworld.domain.test.geography;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.inaworld.domain.character.thread.PopulationManager;

public class PopulationManagerTest {
	PopulationManager populationManager;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void generateCensus() throws Exception {
		populationManager = new PopulationManager();
		
		populationManager.populateCensus();
		
		populationManager.takeCensus();
		System.out.println("That's it");
		
		
	}

	@After
	public void tearDown() throws Exception {
		populationManager = null;
	}
		
	


}
