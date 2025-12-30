package org.example.observer;

import org.example.observable.WeatherObservable;

public class ForcastDisplay implements WeatherObserver{
    private final WeatherObservable weatherStation;

    public ForcastDisplay(WeatherObservable weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Updating weather data to do some analytics: " + weatherStation.toString());
        display();
    }
    public  void display(){
        System.out.println("Forecast Details: Displaying information about Rain, " + "Temperature Trends, Significant Weather Events and other phenomenon");
    }
}
