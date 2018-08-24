package com.example.gof.abstractFactory;

public class Car implements Vehicle {
    @Override
    public void run() {
        System.out.println("可以跑100km/h");
    }

    public void jiayou(){
        System.out.println("可以加油");
    }
}
