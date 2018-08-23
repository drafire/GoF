package com.example.gof.proxy;

import com.example.gof.proxy.impl.BuyCardImpl;

public class TestBuyCardStaticProxy {
    public static void main(String[] args) {
        BuyCard buyCard=new BuyCardImpl();
        buyCard.buycard();
        BuyCardStaticProxy proxy=new BuyCardStaticProxy(buyCard);
        proxy.buycard();
    }
}
