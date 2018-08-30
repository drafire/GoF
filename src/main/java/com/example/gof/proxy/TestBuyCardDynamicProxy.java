package com.example.gof.proxy;

import com.example.gof.proxy.impl.BuyCardImpl;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class TestBuyCardDynamicProxy {
    public static void main(String[] args) throws IOException {
        BuyCard buyCard = new BuyCardImpl();
        BuyCard buyCardProxy = (BuyCard) Proxy.newProxyInstance(BuyCard.class.getClassLoader(),
                new Class[]{BuyCard.class}, new BuyCardDynamicProxy(buyCard));
        buyCardProxy.buycard();

//        byte[] classFile= ProxyGenerator.generateProxyClass("$Proxy", new Class<?>[]{BuyCard.class});
//        File file=new File("D:\\java\\GoF\\src\\main\\java\\com\\example\\gof\\proxy/$Proxy.class");
//        FileOutputStream os=new FileOutputStream(file);
//        os.write(classFile);
//        os.flush();
//        os.close();

    }
}
