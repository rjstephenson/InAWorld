package pattern.observer;

import java.util.ArrayList;
import java.util.List;

public enum Atmosphere implements WeatherSubject { 

	INSTANCE;

	private int oxygenCapacity = 100;
	private List<WeatherObserver> weatherObservers = new ArrayList<WeatherObserver>();
	private Object MUTEX = new Object();

	@Override
	public void registerObserver(WeatherObserver weatherObserver) {
		synchronized (MUTEX) {
			if (!weatherObservers.contains(weatherObserver)) {
				weatherObservers.add(weatherObserver);
			}
		}
	}

	public void resetOxygenCapacity() {
		this.oxygenCapacity = 100;
	}

	public int getOxygen() {
		return oxygenCapacity;
	}

	@Override
	public WeatherObserver getObserver(int i) {
		return weatherObservers.get(i);
	}

	@Override
	public int getObserverCount() {
		return weatherObservers.size();
	}

	@Override
	public void unregisterObserver(WeatherObserver weatherObserver) {
		System.out.println("Unregistering weather subscriber");
		synchronized (MUTEX) {
			weatherObservers.remove(weatherObserver);
		}

	}

	@Override
	public void updateOxygen(int change) {
		oxygenCapacity = oxygenCapacity + change;
		if (this.oxygenCapacity < 0)
			this.oxygenCapacity = 0;

		synchronized (MUTEX) {
			for (WeatherObserver weatherObserver : weatherObservers) {
				weatherObserver.notifyOfOxygenChange(oxygenCapacity,change);
			}
		}
	}

	@Override
	public int getOxygenCapacity() {
		return oxygenCapacity;
	}

	@Override
	public void unregisterAllObservers() {
		System.out.println("Unregistering all weather subscribers");
		synchronized (MUTEX) {
			weatherObservers.removeAll(weatherObservers);
		}

	}

}
