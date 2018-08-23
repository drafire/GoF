package com.example.gof.adapter;

public class TestAdapter {
    public static void main(String[] args) {
        BusToB busToA = new AdapterToA();
        busToA.toB();  //通过适配器，Bus也能去目的地A

        BusToB busToC = new AdapterToC(new CarC());
        busToC.toB();

        VehicleToABCD vehicleToA=new VehicleToA();
        vehicleToA.toA();
    }
}
