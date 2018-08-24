package com.example.gof.abstractFactory;

public class CarFactory implements VehicleFactory {

    @Override
    public Vehicle create() {
        return new Car();
    }

   private String paiLiang;

    public String getPaiLiang() {
        return paiLiang;
    }

    public void setPaiLiang(String paiLiang) {
        this.paiLiang = paiLiang;
    }
}
