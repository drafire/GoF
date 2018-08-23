package com.example.gof.delegate;

/**
 * 策略类，需要添加注解，并使用任务名称中的枚举赋值，才能执行到
 */
@TargetPolicy(value = TargetName.SERVICE)
public class TargetC implements Target {
    @Override
    public void doSomething(String command) {
        System.out.println("售后服务开始啦啦啦");
    }
}
