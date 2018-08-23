package com.example.gof.proxy;

import com.example.gof.proxy.impl.BuyCardImpl;

import java.lang.reflect.Proxy;

public class TestBuyCardDynamicProxy {
    public static void main(String[] args) {
        BuyCard buyCard=new BuyCardImpl();
        BuyCard buyCardProxy= (BuyCard)Proxy.newProxyInstance(BuyCard.class.getClassLoader(),
                new Class[]{BuyCard.class}, new BuyCardDynamicProxy(buyCard));
        buyCardProxy.buycard();
    }
}
