package com.example.gof.decorator;

/**
 * 具体的组件
 */
public class Person implements IPerson {
    @Override
    public void say(String name, String word) {
        System.out.println(name + "说了：" + word);
    }
}
