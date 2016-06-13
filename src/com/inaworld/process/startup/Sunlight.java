package com.inaworld.process.startup;

import java.util.concurrent.Callable;

public class Sunlight implements Callable<Sunlight> {
	private Meteorology meteorology;

	public Sunlight(Meteorology meteorology) {
		this.meteorology = meteorology;
	}
	
	public String getTimeOfDay() {
		return meteorology.getTimeOfDay();
	}
	 
	@Override
	public Sunlight call() throws Exception {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println(getTimeOfDay() + "Sunlight!");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				System.out.println("Sunlight stopped at: " + getTimeOfDay());
				return this;
			}
		}
		return this;
	}
}
