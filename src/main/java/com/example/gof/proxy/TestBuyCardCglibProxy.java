package com.example.gof.proxy;

import com.example.gof.proxy.impl.BuyCardImpl;

public class TestBuyCardCglibProxy {
    public static void main(String[] args) {
        BuyCard buyCard=new BuyCardImpl();
        BuyCardCglibProxy proxy=new BuyCardCglibProxy();
        BuyCardImpl impl= (BuyCardImpl)proxy.getInstance(buyCard);
        impl.buycard();
    }
}
