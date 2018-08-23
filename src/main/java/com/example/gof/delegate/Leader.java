package com.example.gof.delegate;

import java.util.HashMap;
import java.util.Map;

public class Leader {
    private Map<String, Target> targets = new HashMap<>();

    /**
     * 主要是这里，维护了子类（有点类似于策略）的引用。如果子类较多，这里维护起来就很麻烦了。不过可以使用注解的方式，
     * 每次加载的时候，都会扫描包下拥有这个注解的子类，并添加到map中
     */
    public Leader() {
//        targets.put("加密",new TargetA());
//        targets.put("销售",new TargetB());
    }

    public void dispatch(TargetName targetName) {
        Target target = targets.get(targetName.getKey());
        if (target == null) {
            System.out.println("not found" + TargetName.class.getName() + "." + targetName.getKey() + " in delegate");
            return;
        }
        target.doSomething(targetName.getKey());
    }

    public void addTarget(TargetName targetName, Target target) {
        targets.put(targetName.getKey(), target);
    }
}
