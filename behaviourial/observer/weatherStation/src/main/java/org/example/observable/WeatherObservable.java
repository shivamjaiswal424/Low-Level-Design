package org.example.observable;

import org.example.observer.WeatherObserver;

public interface WeatherObservable {

    void addObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
    void setWeatherReadings(float temperature, float humidity,float pressure);
}
