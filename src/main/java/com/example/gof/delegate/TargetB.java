package com.example.gof.delegate;

@TargetPolicy(value = TargetName.SELL)
public class TargetB implements Target {
    @Override
    public void doSomething(String command) {
        System.out.println("销售软件啦啦啦啦");
    }
}
