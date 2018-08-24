package com.example.gof.observer;

public class ReaderA implements Reader {
    private String name;

    public ReaderA(String name) {
        this.name = name;
    }

    @Override
    public void getMessage(String message) {
        System.out.println(name + "接收到了消息：" + message);
    }
}
