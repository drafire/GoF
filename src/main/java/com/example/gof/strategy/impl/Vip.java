package com.example.gof.strategy.impl;

import com.example.gof.strategy.CalPrice;
import com.example.gof.strategy.PriceRegion;

/**
 * vip
 */
@PriceRegion(min = 10001,max = 20000)
public class Vip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.8;
    }
}
