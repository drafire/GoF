package com.example.gof.strategy;

public class TestStategy {
    public static void main(String[] args) {
        Player player=new Player();
        player.buy(100050D);
        System.out.println(player.calLastAmount());
    }
}
