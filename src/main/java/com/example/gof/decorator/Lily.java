package com.example.gof.decorator;

/**
 *具体的装饰器
 */
public class Lily extends Teacher {
    public Lily(IPerson iPerson) {
        super(iPerson);
    }

    @Override
    public void say(String name, String word) {
        super.say(name, word);
        System.out.println("我是lily老师");
    }

    public void busyWork(){
        System.out.println("lily布置作业了");
    }
}
