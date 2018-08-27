package com.example.gof.propotype;

import java.util.Date;

public class TestPropotype {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(10);
        student.setBirthDay(new Date());
        student.setName("abc");
        student.setWork(new Work("microsoft", 1000, "行政"));

        Student simpleCopy = student.clone();
        System.out.println(simpleCopy==(student));
        System.out.println(simpleCopy.getAge() == student.getAge());
        System.out.println(simpleCopy.getBirthDay()==(student.getBirthDay()));   //这里是引用赋值，不再是值类型赋值，所以相等

        System.out.println("--------------------------------------------------------------------------------------------------------");

        Student deepyClone = student.deepyClone();
        System.out.println(deepyClone==(student));
        System.out.println(student.getAge() == deepyClone.getAge());
        System.out.println("原来的生日：" + student.getBirthDay() + "，深度复制的生日：" + deepyClone.getBirthDay());
        System.out.println(student.getBirthDay()==deepyClone.getBirthDay());   //这里不能用equals，因为Date已经重写了equals的方法

        System.out.println("原来的工作：" +student.getWork().getCompany()+"-"+ student.getWork().getJob() + "，深度复制的工作："
                + deepyClone.getWork().getCompany()+"-"+deepyClone.getWork().getJob());
        System.out.println(student.getWork()==(deepyClone.getWork()));

    }
}
