package com.joe.designpattern.commandpattern.items;

public class Stereo {
    private int Volume;
    private String location;

    public Stereo(String location) {
        this.location = location;
    }

    public Stereo() {
    }

    public void on(){
        System.out.println("打開"+location+"音響。");
    }
    public void off(){
        System.out.println("關掉"+location+"音響。");
    }

    public void setCd(){
        System.out.println("放入CD。");
    }

    public void setDvd(){
        System.out.println("放入DVD");
    }

    public void Radio(){
        System.out.println("放入Radio。");
    }

    public void setVolume(int Volume){
        this.Volume=Volume;
        System.out.println("調整音量為: "+Volume);
    }
}
