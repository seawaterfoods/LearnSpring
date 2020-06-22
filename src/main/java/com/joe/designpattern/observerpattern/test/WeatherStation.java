package com.joe.designpattern.observerpattern.test;

import com.joe.designpattern.observerpattern.CurrentConditionsDisplay;
import com.joe.designpattern.observerpattern.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay conditionsDisplay=new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4f);

//        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
//        System.out.print("display:");
//        conditionsDisplay.display();
//        System.out.print("update:");
//        conditionsDisplay.update(30,65,30.4f);

    }
}
