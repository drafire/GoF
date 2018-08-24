package com.example.gof.observer;

import java.util.ArrayList;
import java.util.List;

public class PublisherA implements Publisher {
    private List<Reader> list;
    private String message;

    public PublisherA() {
        this.list = new ArrayList<>();
    }

    @Override
    public void registerReader(Reader reader) {
        list.add(reader);
    }

    @Override
    public void removeReader(Reader reader) {
        list.remove(reader);
    }

    @Override
    public void notifyReader() {
        for (Reader reader:
             list) {
            reader.getMessage(this.message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
