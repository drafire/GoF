package com.example.gof.delegate;

@TargetPolicy(value = TargetName.STUDY)
public class TargetA implements Target {
    @Override
    public void doSomething(String command) {
        System.out.println("研发代码");
    }
}
