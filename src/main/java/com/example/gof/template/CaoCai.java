package com.example.gof.template;

/**
 * 炒菜模板
 */
public abstract class CaoCai implements Kitchen {

    @Override
    public final void proceed() {
        xiCai();
        cao();
        shengCai();
    }
    //炒菜
    public abstract void cao();

    private void xiCai(){
        System.out.println("洗菜");
    }
    private void shengCai(){
        System.out.println("把菜剩起来");
    }
}
