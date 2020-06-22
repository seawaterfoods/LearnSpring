package com.joe.designpattern.observerpattern;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer,DisplayElement {

    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay (Observable observable){
        WeatherData weatherData = (WeatherData)observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData){
            lastPressure = currentPressure;
            currentPressure = ((WeatherData) observable).getPressure();
            display();
        }
    }
    @Override
    public void display() {}
}
