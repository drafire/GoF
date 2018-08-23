package com.example.gof.strategy;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CalPriceFactory {
    private static final String CAL_PACKAGE_PRICE = "com.example.gof.strategy.impl";  //要扫描的包

    private ClassLoader loader = getClass().getClassLoader();

    private List<Class<? extends CalPrice>> calPriceList;   //策略类列表

    public CalPrice createCalPrice(Player player) {
        for (Class<? extends CalPrice> clazz : calPriceList) {
            //获得策略类的注解
            PriceRegion priceRegion = handleAnnotation(clazz);
            //判断金额是否在注解的区间
            if (player.getTotalAmount() > priceRegion.min() && player.getTotalAmount() < priceRegion.max()) {
                try {
                    return clazz.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new RuntimeException("策略获得失败");
    }

    //获得注解
    private PriceRegion handleAnnotation(Class<? extends CalPrice> clazz) {
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (annotations == null || annotations.length < 1) {
            return null;
        }
        for (Annotation annotation : annotations) {
            if (annotation instanceof PriceRegion) {
                return (PriceRegion) annotation;
            }
        }
        return null;
    }

    private void init() {
        calPriceList = new ArrayList<>();
        File[] resource = getResources();
        Class<CalPrice> calPriceClazz = null;
        try {
            calPriceClazz = (Class<CalPrice>) loader.loadClass(CalPrice.class.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("未找到策略资源");
        }

        for (int i = 0; i < resource.length; i++) {
            //载入包下的所有类
            try {
                Class<?> claszz = loader.loadClass(CAL_PACKAGE_PRICE + "." + resource[i].getName().replace(".class", ""));
                //判断是否是策略类并且不是自身
                if (CalPrice.class.isAssignableFrom(claszz) && claszz != calPriceClazz) {
                    calPriceList.add((Class<? extends CalPrice>) claszz);  //这里表示转换成继承接口的类，也可以直接表示成Class<CalPrice>
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //获取包下的所有class类
    private File[] getResources() {
        try {
            File file = new File(loader.getResource(CAL_PACKAGE_PRICE.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".class")) { //只扫描class
                        return true;
                    }
                    return false;
                }
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }

    public static CalPriceFactory getInstance() {
        return CalPriceFactoryInstance.instance;
    }

    private static class CalPriceFactoryInstance {
        private static CalPriceFactory instance = new CalPriceFactory();
    }

    private CalPriceFactory() {
        init();
    }
}
