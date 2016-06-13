package com.atmosphere;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pattern.observer.Atmosphere;

import com.inaworld.domain.character.Character;

public class AtmosphereTest {
	Atmosphere atmosphere = Atmosphere.INSTANCE;

	@Before
	public void setup() {
		atmosphere.resetOxygenCapacity();
		atmosphere.unregisterAllObservers();
	}

	@Test
	public void whenFirstCreatedOxygenEqual100Percent() {
		assertEquals(atmosphere.getOxygen(), 100);
	}

	@Test
	public void when100PercentOxygenReducedBy1Then99() {
		atmosphere.updateOxygen(-1);
		assertEquals(atmosphere.getOxygen(), 99);
	}

	@Test
	public void when100PercentOxygenReducedAndResetThen100() {
		atmosphere.updateOxygen(-1);
		atmosphere.resetOxygenCapacity();
		assertEquals(atmosphere.getOxygen(), 100);
	}

	@Test
	public void when100PercentOxygenReducedBy10Then90() {
		atmosphere.updateOxygen(-10);
		assertEquals(atmosphere.getOxygen(), 90);
	}

	@Test
	public void whenOxygenReducedByMoreThan100Then0() {
		atmosphere.updateOxygen(-210);
		assertEquals(atmosphere.getOxygen(), 0);
	}

	@Test
	public void whenRegisteringSeveralObserversThenNoErrors() {
		atmosphere.registerObserver(new Character.Builder().name().characterAtribs().build());
		atmosphere.registerObserver(new Character.Builder().name().characterAtribs().build());
		atmosphere.registerObserver(new Character.Builder().name().characterAtribs().build());

		assertTrue(true);
	}

	@Test
	public void whenRegisteringOneObserverThenCountisOne() {
		atmosphere.registerObserver(new Character.Builder().name().characterAtribs().build());
		assertEquals(1,atmosphere.getObserverCount());
	}

	@Test
	public void whenRegisteringThreeObserverThenCountis3() {
		atmosphere.registerObserver(new Character.Builder().name().characterAtribs().build());
		atmosphere.registerObserver(new Character.Builder().name().characterAtribs().build());
		atmosphere.registerObserver(new Character.Builder().name().characterAtribs().build());

		assertEquals(3,atmosphere.getObserverCount());
	}

	@Test
	public void whenUnRegisteringAnEmptyCollectionNothingHappens() {
		atmosphere.unregisterObserver(new Character.Builder().name().characterAtribs().build());
		assertEquals(0,atmosphere.getObserverCount());
	}

}
