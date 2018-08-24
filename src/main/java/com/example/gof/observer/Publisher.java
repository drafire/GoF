package com.example.gof.observer;

/**
 * 发布者
 */
public interface Publisher {
    void registerReader(Reader reader);
    void removeReader(Reader reader);
    void notifyReader();
}
