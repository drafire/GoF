package com.example.gof.decorator;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

public class TestDecorator  {
    public static void main(String[] args) {
        Person person=new Person();

        Lily lily=new Lily(person);
        lily.say("lily","大家好");
        //lily.busyWork();

        System.out.println("");

        Tom tom=new Tom(person);
        tom.say("tom","我是帅哥tom");
    }
}
