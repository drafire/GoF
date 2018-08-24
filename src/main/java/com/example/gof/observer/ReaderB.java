package com.example.gof.observer;

public class ReaderB implements Reader {
    private String name;

    public ReaderB(String name) {
        this.name = name;
    }

    @Override
    public void getMessage(String message) {
        int a = 1;
        int b = 2;
        System.out.println(name + "，接收到消息：" + message + "，进行了计算，结果：" + (a + b));
    }
}
