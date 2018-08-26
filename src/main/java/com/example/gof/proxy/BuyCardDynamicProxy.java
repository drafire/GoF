package com.example.gof.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BuyCardDynamicProxy implements InvocationHandler {
    private Object object;

    public BuyCardDynamicProxy(final Object object) {
        this.object = object;
    }

    /**
     *  代理回调的方法，反编译后可以看到调用的是这段代码:super.h.invoke(this, m3, null);
     *  m3 = Class.forName("com.example.gof.proxy.BuyCard").getMethod("buycard", new Class[0]);
     * @param proxy 代理
     * @param method  代理调用的而方法
     * @param args 调用的方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理，买车前");
        Object res= method.invoke(object,args);
        System.out.println("动态代理，洗刷刷");
        return res;
    }
}
