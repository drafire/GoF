package com.example.gof.delegate;

public class TestDelegate {
    public static void main(String[] args) {
        DelegateFactory delegateFactory=DelegateFactory.getInstance();
        Leader leader=delegateFactory.getLeader();
        leader.dispatch(TargetName.SERVICE);
    }
}
