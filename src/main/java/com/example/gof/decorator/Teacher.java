package com.example.gof.decorator;

/**
 * 装饰器
 */
public class Teacher implements IPerson {
    private IPerson iPerson;

    public Teacher(IPerson iPerson) {
        this.iPerson = iPerson;
    }

    @Override
    public void say(String name, String word) {
        iPerson.say(name, word);
        System.out.println("开始上课了");
    }
}
