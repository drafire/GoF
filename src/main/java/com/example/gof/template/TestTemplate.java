package com.example.gof.template;

public class TestTemplate {
    public static void main(String[] args) {
        Kitchen bocai=new ChaoBoCai();
        Kitchen fanQie=new CaoFanQie();
        bocai.proceed();
        fanQie.proceed();
    }
}
