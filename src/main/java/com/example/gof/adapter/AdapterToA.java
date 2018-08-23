package com.example.gof.adapter;

public class AdapterToA extends CarA implements BusToB {
    @Override
    public void toB() {
        toA();
    }
}
