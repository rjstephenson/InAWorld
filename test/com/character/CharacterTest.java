package com.character;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pattern.observer.WeatherObserver;

import com.inaworld.domain.character.Character;

public class CharacterTest {
	WeatherObserver weatherObserver;
	
	@Before
	public void setup() {
		weatherObserver = new Character.Builder().name().characterAtribs().build();
	}
	
	@Test
	public void whenNotifiedOfOxygenDecreasesThenNotificationReceived() {
		weatherObserver.notifyOfOxygenChange(99,-1);
		Character character = (Character) weatherObserver;
		assertEquals("Notify Recieved. Change is -1%",character.getThoughts());
	}

	@Test
	public void whenNotifiedOfOxygenReachesZeroThenNotificationReceived() {
		weatherObserver.notifyOfOxygenChange(0,-100);
		Character character = (Character) weatherObserver;
		assertEquals("Notify Recieved. Change is -100%",character.getThoughts());
	}

}
