package com.inaworld.process.startup;

import java.util.concurrent.Callable;

public class Meteorology implements Callable<Meteorology> {

	private int timeOfDay = 8;
	private static final int interval = 1;

	public String getTimeOfDay() {
		if (timeOfDay < 12)
			return timeOfDay + "AM";
		if (timeOfDay == 12)
			return timeOfDay + "PM";
		if (timeOfDay == 24)
			return timeOfDay - 12 + "AM";
		return timeOfDay - 12 + "PM";
	}

	public String getConditions() {
		if (timeOfDay >= 6 && timeOfDay <= 15) {
			return "Sunny";
		}
		if (timeOfDay >= 16 && timeOfDay <= 24) {
			return "Raining";
		}
		if (timeOfDay <= 5) {
			return "Cloudy";
		}

		return null;

	}

	public int getSunlight() {
		int sunlight = 100;
		switch (timeOfDay) {
		case 1:
			sunlight = 0;
			break;
		case 2:
			sunlight = 0;
			break;
		case 3:
			sunlight = 0;
			break;
		case 4:
			sunlight = 20;
			break;
		case 5:
			sunlight = 40;
			break;
		case 6:
			sunlight = 60;
			break;
		case 7:
			sunlight = 80;
			break;
		case 8:
			sunlight = 100;
			break;
		case 9:
			sunlight = 100;
			break;
		case 10:
			sunlight = 100;
			break;
		case 11:
			sunlight = 100;
			break;
		case 12:
			sunlight = 100;
			break;
		case 13:
			sunlight = 100;
			break;
		case 14:
			sunlight = 100;
			break;
		case 15:
			sunlight = 100;
			break;
		case 16:
			sunlight = 100;
			break;
		case 17:
			sunlight = 100;
			break;
		case 18:
			sunlight = 100;
			break;
		case 19:
			sunlight = 80;
			break;
		case 20:
			sunlight = 60;
			break;
		case 21:
			sunlight = 40;
			break;
		case 22:
			sunlight = 20;
			break;
		case 23:
			sunlight = 0;
			break;
		case 24:
			sunlight = 0;
			break;

		default:
			break;
		}
		return sunlight;
	}

	private void incrementTimeOfDay() {
		timeOfDay = timeOfDay + interval;
		if (timeOfDay > 24) {
			timeOfDay = 1;
		}
	}

	@Override
	public Meteorology call() throws Exception {
		while (!Thread.currentThread().isInterrupted()) {
			incrementTimeOfDay();
			System.out.println(getTimeOfDay() + getConditions() + getSunlight());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("Time stopped at: " + getTimeOfDay());
				return this;
			}
		}
		return this;
	}
}
