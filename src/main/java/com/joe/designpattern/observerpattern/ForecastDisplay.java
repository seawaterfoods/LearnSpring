package com.joe.designpattern.observerpattern;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer,DisplayElement {

    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay (Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData) observable;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }
    @Override
    public void display() {
        System.out.print("預測: ");
        if (currentPressure > lastPressure) {
            System.out.println("天氣變好了！");
        } else if (currentPressure == lastPressure) {
            System.out.println("沒啥變化。");
        } else if (currentPressure < lastPressure) {
            System.out.println("今天天氣有可能會下雨！");
        }
    }
}
