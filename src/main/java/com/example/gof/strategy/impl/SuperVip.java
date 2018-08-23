package com.example.gof.strategy.impl;

import com.example.gof.strategy.CalPrice;
import com.example.gof.strategy.PriceRegion;

/**
 * 超级vip
 */
@PriceRegion(min = 20001,max = 100000)
public class SuperVip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.6;
    }
}
