package com.example.gof.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class BuyCardCglibProxy implements MethodInterceptor {
    private Object target;

    public Object getInstance(final Object target) {
        this.target = target;
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理前");
        //这里使用的是methodProxy.invokeSuper，而不是method.invoke
        //代理类调用父类的方法
        Object res= methodProxy.invokeSuper(o,objects);
        System.out.println("cglib动态代理后");
        return res;
    }
}
