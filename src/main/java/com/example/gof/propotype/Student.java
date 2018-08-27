package com.example.gof.propotype;

import java.io.*;
import java.util.Date;

public class Student implements Cloneable,Serializable {
    private String name;
    private int age;
    private Date birthDay;
    private Work work;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Student clone() {
        try {
            Student student = (Student) super.clone();
            return student;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Student deepyClone(){
        try {
            //将对象序列化
            ByteArrayOutputStream bas=new ByteArrayOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(bas);
            oos.writeObject(this);

            ByteArrayInputStream bis=new ByteArrayInputStream(bas.toByteArray());
            ObjectInputStream ois=new ObjectInputStream(bis);
            try {
                Student student=(Student)ois.readObject();
                return student;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
