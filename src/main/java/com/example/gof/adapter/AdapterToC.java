package com.example.gof.adapter;

public class AdapterToC implements BusToB {
    private CarC carC;

    public AdapterToC(CarC carC) {
        this.carC = carC;
    }

    @Override
    public void toB() {
        carC.toC();
    }
}
