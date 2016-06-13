package com.atmosphere;

import static org.junit.Assert.*;

import org.junit.*;

import pattern.observer.Atmosphere;
import pattern.observer.WeatherObserver;
import pattern.observer.WeatherSubject;

import com.inaworld.domain.character.Character;

public class AtmosphereObserverTest {
	WeatherObserver weatherObserver;
	WeatherSubject weatherSubject;
	@Before
	public void setup() {
		weatherObserver = null;
		weatherObserver =	new Character.Builder().name().characterAtribs().build();
		weatherSubject = null;
		weatherSubject= Atmosphere.INSTANCE;
		weatherSubject.registerObserver(weatherObserver);
	}

	@Test
	public void whenObserverisRegisterThenNothingFails() {
		assertTrue(true);
	}

	@Test
	public void whenObserverisRegisterThenItCanBeReturned() {
		WeatherObserver weatherObserver = weatherSubject.getObserver(0);
		assertFalse(weatherObserver==null);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void whenObserverisNotRegisterThenItCanBeReturned() {
		WeatherObserver weatherObserver = weatherSubject.getObserver(999);
		assertTrue(weatherObserver==null);
	}

	@Test
	public void whenObserverisNotifiedThen() {
		Atmosphere.INSTANCE.updateOxygen(-5);
		Character character = (Character) weatherObserver;
		System.out.println("x" + character.getThoughts());
		assertTrue(true);
	}

}
