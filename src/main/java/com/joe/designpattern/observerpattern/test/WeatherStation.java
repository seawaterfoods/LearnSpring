package com.joe.designpattern.observerpattern.test;

import com.joe.designpattern.observerpattern.CurrentConditionsDisplay;
import com.joe.designpattern.observerpattern.ForecastDisplay;
import com.joe.designpattern.observerpattern.StatisticsDisplay;
import com.joe.designpattern.observerpattern.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {


        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
//        WeatherData weatherData = new WeatherData();
//        CurrentConditionsDisplay conditionsDisplay=new CurrentConditionsDisplay(weatherData);
//
//        weatherData.setMeasurements(80,65,30.4f);

//        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
//        System.out.print("display:");
//        conditionsDisplay.display();
//        System.out.print("update:");
//        conditionsDisplay.update(30,65,30.4f);

    }
}
