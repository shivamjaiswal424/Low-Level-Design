package org.example;
import org.example.observable.WeatherObservable;
import org.example.observable.WeatherStation;
import org.example.observer.CurrentConditionsDisplay;
import org.example.observer.ForcastDisplay;

public class WeatherStationApp{
    public static void main(String[] args) {
        System.out.println("###### State Design Pattern ######");
        WeatherObservable weatherStation=new WeatherStation();

        CurrentConditionsDisplay currentConditionsDisplay=new CurrentConditionsDisplay(weatherStation);
        ForcastDisplay forcastDisplay=new ForcastDisplay(weatherStation);

        System.out.println("=====>> Initial Weather Update");
        weatherStation.setWeatherReadings(80,65,30.4f);

        System.out.println("=====>> Second Weather Update");
        weatherStation.setWeatherReadings(82,70,29.42f);

        weatherStation.removeObserver(forcastDisplay);

        System.out.println("===>>> Third Weather Update");
        weatherStation.setWeatherReadings(70,21,29.2f);

    }
}