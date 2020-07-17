package com.joe.designpattern.observerpattern;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer,DisplayElement {

//    private Subject weatherData;
    Observable observable;
    private float temperature;
    private float humidity;
//condimentCost
//現在構造器需要一個Observable當參數，並將CurrentConditionsDisplay Object登記成為觀察者
    public CurrentConditionsDisplay(Observable observable){
//        this.weatherData = weatherData;
//        weatherData.registerObserver(this);
        this.observable = observable;
        observable.addObserver(this);
    }
//增加Observable和DATA　Object作為參數
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData){
//            在update()中，先確定可觀察者屬於WeatherData class，然後再用getter()獲取data最後再調用display
            WeatherData weatherData = (WeatherData)observable;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public void display() {
        System.out.println("當前天氣狀況，目前溫度: 華氏"+temperature+"度 與 濕度:"+humidity+"%\n");
    }


}
