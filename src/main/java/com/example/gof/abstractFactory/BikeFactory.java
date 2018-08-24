package com.example.gof.abstractFactory;

public class BikeFactory implements VehicleFactory {
    /**
     * 关键点在于这里，返回一个实体的产品
     * @return
     */
    @Override
    public Vehicle create() {
      return new Bike();
    }

    private String chicun;

    public String getChicun() {
        return chicun;
    }

    public void setChicun(String chicun) {
        this.chicun = chicun;
    }
}
