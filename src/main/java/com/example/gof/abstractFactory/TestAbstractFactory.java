package com.example.gof.abstractFactory;

public class TestAbstractFactory {
    public static void main(String[] args) {

        /**
         * 后续如果需要再增加产品，只需要增加该工厂和产品即可，不再需要修改原来的工厂方法
         * 这样是符合开闭原则的
         */
        VehicleFactory factory = new BikeFactory();
        Bike bike = (Bike) factory.create();
        bike.run();
        bike.daqi();

        System.out.println("----------------------------------------------");

        factory = new CarFactory();
        Car car = (Car) factory.create();
        car.jiayou();
        car.run();
    }
}
