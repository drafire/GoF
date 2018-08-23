package com.example.gof.strategy.impl;

import com.example.gof.strategy.CalPrice;
import com.example.gof.strategy.PriceRegion;

@PriceRegion(min = 100001)
public class Golden implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.4;
    }
}
