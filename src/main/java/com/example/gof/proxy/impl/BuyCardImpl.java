package com.example.gof.proxy.impl;

import com.example.gof.proxy.BuyCard;

public class BuyCardImpl implements BuyCard {
    @Override
    public void buycard() {
        System.out.println("买车了");
    }
}
