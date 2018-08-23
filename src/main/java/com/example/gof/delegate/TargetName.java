package com.example.gof.delegate;

public enum  TargetName {
    STUDY("研发"),
    SELL("销售"),
    SERVICE("售后");
    private String key;

    TargetName(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
