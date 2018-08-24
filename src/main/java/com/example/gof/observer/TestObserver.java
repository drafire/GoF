package com.example.gof.observer;

public class TestObserver {
    public static void main(String[] args) {
        /**
         * 观察者模式中，被观察者做出改变后，需要调用观察者提供的方法进行回调，来达到通知观察者的目的
         * 被观察者是采取循环的方式去通知观察者的
         */
        PublisherA publisher = new PublisherA();

        Reader readerA = new ReaderA("lily");
        publisher.registerReader(readerA);

        Reader readerB = new ReaderB("tom");
        publisher.registerReader(readerB);

        ReaderC readerC = new ReaderC("sam");
        publisher.registerReader(readerC);

        publisher.setMessage("布置作业啦");
        publisher.notifyReader();

        System.out.println("---------------------------------------------------");

        publisher.setMessage("明天考试");
        publisher.removeReader(readerC);
        publisher.notifyReader();
    }
}
