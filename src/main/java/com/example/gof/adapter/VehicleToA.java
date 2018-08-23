package com.example.gof.adapter;

public class VehicleToA extends AdapterABCD {
    //这样重写了，还有什么意义？不知道实际场景该如何使用。
    @Override
    public void toA() {
        System.out.println("Vehicle to A");
    }
}
