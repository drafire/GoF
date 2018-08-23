package com.example.gof.proxy;

/**
 * 买车静态代理
 */
public class BuyCardStaticProxy implements BuyCard {
    private BuyCard buyCard;
    public BuyCardStaticProxy(BuyCard buyCard) {
        this.buyCard=buyCard;
    }

    @Override
    public void buycard() {
        System.out.println("静态代理，买车前");
        buyCard.buycard();
        System.out.println("静态代理，买车后");
    }
}
