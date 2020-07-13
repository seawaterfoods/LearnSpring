package com.joe.designpattern.observerpattern;

import java.util.Observable;

public class WeatherData extends Observable {

//    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
    }
    public void  measurementsChanged(){
        //再調用notifyObservers()前須先使用setChange()來只是改變狀態
        setChanged();
//        我們沒有在調用notifyObservers()時傳輸DATA物件，表示我們採用"pull"
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    //
//    @Override
//    public void registerObserver(Observer observer) {
//        observers.add(observer);
//    }
//
//    @Override
//    public void removeObserver(Observer observer) {
//        int i = observers.indexOf(observer);
//        if (i>0){
//            observers.remove(i);
//        }
//    }
//
//    @Override
//    public void notifyObservers() {
//        for(int i = 0; i <observers.size();i++){
//            Observer observer = (Observer)observers.get(i);
//            observer.update(temperature,humidity,pressure);
//        }
//    }
//
//    public void measurementsChanged(){
//        notifyObservers();
//    }
//

//    WeatherData的其他方法
}
