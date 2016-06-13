package com.inaworld.domain.character;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import pattern.observer.Atmosphere;
import pattern.observer.WeatherObserver;
import pattern.observer.WeatherSubject;

import com.inaworld.domain.character.thread.Randomizer;

public class Character implements Callable<Character>, WeatherObserver {

	private static final String OH_NO_DEATH_ENTERS = "Oh no!!!!!! <death enters>";
	private static final String OH_CRAP_I_MIGHT_DIE = "Oh Yikes! ";
	private String name;
	private Map<String, Integer> characterAtribs = new HashMap<String, Integer>();
	private volatile boolean everyLives = true;
	private WeatherSubject weatherSubject = Atmosphere.INSTANCE;
	private String thoughts;

	private Character(Builder builder) {
		this.name = builder.name;
		this.characterAtribs = builder.characterAtribs;
	}

	public Map<String, Integer> getCharacterAtribs() {
		return characterAtribs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name + " " + characterAtribs.toString();

	}

	public static class Builder {
		/**
		 * Required parameters
		 */
		private String name;

		private Map<String, Integer> characterAtribs = new HashMap<String, Integer>();

		// Create brand new character
		public Builder characterAtribs() {
			List<AttribDef> attribDefs = AttribDefsCache.INSTANCE.getAttribDefs();
			for (AttribDef attribDef : attribDefs) {
				characterAtribs.put(attribDef.getName(), Randomizer.lowToHigh(attribDef.getMin(), attribDef.getMax(), 5));
			}
			return this;
		}

		// Create new instance of old character
		public Builder characterAtribs(Map<String, Integer> oldCharacterAttribs, Map<String, Integer> changedCharacterAttribs) {
			for (String attribName : oldCharacterAttribs.keySet()) {
				if (changedCharacterAttribs.get(attribName) != null) {
					characterAtribs.put(attribName, changedCharacterAttribs.get(attribName));
				} else {
					characterAtribs.put(attribName, oldCharacterAttribs.get(attribName));
				}
			}
			return this;
		}

		// create new character name
		public Builder name() {
			List<String> starts = NameSegmentsCache.INSTANCE.getNameStarts();
			List<String> ends = NameSegmentsCache.INSTANCE.getNameEnds();
			StringBuffer n = new StringBuffer();
			for (int i = 1; i <= Randomizer.lowToHigh(2, 4); i++) {
				n.append(starts.get(Randomizer.lowToHigh(0, starts.size() - 1)));
				n.append(ends.get(Randomizer.lowToHigh(0, ends.size() - 1)));
			}
			name = n.toString().substring(0, 1).toUpperCase() + n.substring(1);
			return this;
		}

		// new instance of old character
		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Character build() {
			return new Character(this);
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) {
			System.out.println(new Character.Builder().name().characterAtribs().build());
		}
	}

	@Override
	public Character call() throws Exception {
		while (isEveryLives()) {
			System.out.println(getName() + " lives.");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println(getName() + " is dead!!!!!!!!!!!!!!!!!!!!!");
				return this;
			}
		}

		System.out.println(getName() + " is dead.");

		return this;
	}

	public void setEveryLives(boolean everyLives) {
		this.everyLives = everyLives;
	}

	public boolean isEveryLives() {
		return everyLives;
	}

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	@Override
	public void notifyOfOxygenChange(int oxygenCapacity,int change) {
		
		System.out.println("I've been notified of a change in oxygen of: " + change + "% Oxygen is now " + oxygenCapacity + "%");
		if (getAtmosphere().getOxygenCapacity() == 100)
			setThoughts("Notify Recieved. Change is " + change + "%");
		if (getAtmosphere().getOxygenCapacity() == 0)
			setThoughts(OH_NO_DEATH_ENTERS);
		if (getAtmosphere().getOxygenCapacity() < 100)
			setThoughts(OH_CRAP_I_MIGHT_DIE);
	}

	private WeatherSubject getAtmosphere() {
		return weatherSubject;
	}
}
