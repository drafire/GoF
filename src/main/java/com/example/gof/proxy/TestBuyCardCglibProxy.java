package com.example.gof.proxy;

import com.example.gof.proxy.impl.BuyCardImpl;
import org.springframework.cglib.core.DebuggingClassWriter;

public class TestBuyCardCglibProxy {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, TestBuyCardCglibProxy.class.getClass().getResource("/").getPath() );
        BuyCard buyCard=new BuyCardImpl();
        BuyCardCglibProxy proxy=new BuyCardCglibProxy();
        BuyCardImpl impl= (BuyCardImpl)proxy.getInstance(buyCard);
        impl.buycard();
    }
}
