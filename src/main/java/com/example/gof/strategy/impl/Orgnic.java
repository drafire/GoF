package com.example.gof.strategy.impl;

import com.example.gof.strategy.CalPrice;
import com.example.gof.strategy.PriceRegion;

/**
 * 普通用户
 */
@PriceRegion(max = 10000,min = 0)
public class Orgnic implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice;
    }
}
