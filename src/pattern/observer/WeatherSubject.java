package pattern.observer;

public interface WeatherSubject {

	void registerObserver(WeatherObserver observer1);
	void unregisterObserver(WeatherObserver observer1);
	void unregisterAllObservers();
	
	WeatherObserver getObserver(int i);
	int getObserverCount();
	void updateOxygen(int change);
	int getOxygenCapacity();
//	void notify();

}
