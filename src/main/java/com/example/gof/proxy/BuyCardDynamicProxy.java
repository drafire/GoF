package com.example.gof.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BuyCardDynamicProxy implements InvocationHandler {
    private Object object;

    public BuyCardDynamicProxy(final Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理，买车前");
        Object res= method.invoke(object,args);
        System.out.println("动态代理，洗刷刷");
        return res;
    }
}
