package com.example.gof.observer;

public class ReaderC implements Reader {
    private String name;

    public ReaderC(String name) {
        this.name = name;
    }

    @Override
    public void getMessage(String message) {
        int a = 51;
        int b = 2;
        System.out.println(name + "，接收到消息后，内心好无波澜，并做了乘法，结果：" + (a * b));
    }
}
