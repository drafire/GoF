package com.example.gof.abstractFactory;

public class Bike implements Vehicle {
    @Override
    public void run() {
        System.out.println("可以跑20km/h");
    }

    public void daqi(){
        System.out.println("可以打气");
    }
}
