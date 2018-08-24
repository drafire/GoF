package com.example.gof.decorator;

/**
 * 具体的装饰器
 */
public class Tom extends Teacher {
    public Tom(IPerson iPerson) {
        super(iPerson);
    }

    public void play(){
        System.out.println("玩游戏");
    }
}
