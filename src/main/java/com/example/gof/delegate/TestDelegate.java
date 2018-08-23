package com.example.gof.delegate;

import java.lang.annotation.Annotation;

public class TestDelegate {
    public static void main(String[] args) {
        Leader leader = new Leader();
        leader.dispatch("销售");
    }



}
