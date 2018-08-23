package com.example.gof.delegate;

import com.example.gof.Util.DIUtil;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class DelegateFactory extends DIUtil<Target> {
    private ClassLoader classLoader = getClass().getClassLoader();

    private static final String PACKAGE_NAME = "com.example.gof.delegate";

    private Leader leader;

    private void init() {
        List<Class<? extends Target>> targetList = getDelegateList(PACKAGE_NAME);
        leader = new Leader();
        for (Class<? extends Target> clazz : targetList) {
            //获得策略注解
            TargetPolicy policy = handleAnnotation(clazz);
            if(policy==null){
                continue;
            }
            try {
                leader.addTarget(policy.value(), clazz.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Class<? extends Target>> getList(File[] resource) {
        List<Class<? extends Target>> list = new ArrayList<>();
        Class<Target> targetClazz = null;
        try {
            targetClazz = (Class<Target>) classLoader.loadClass(Target.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < resource.length; i++) {
            try {
                Class<?> clazz = classLoader.loadClass(PACKAGE_NAME + "." + resource[i].getName().replace(".class", ""));
                if (Target.class.isAssignableFrom(clazz) && clazz != targetClazz) {
                    list.add((Class<? extends Target>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    public TargetPolicy handleAnnotation(Class<? extends Target> clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        if (annotations == null || annotations.length < 1) {
            return null;
        }
        for (Annotation annotation :
                annotations) {
            if (annotation instanceof TargetPolicy) {
                return (TargetPolicy) annotation;
            }
        }
        return null;
    }

    private DelegateFactory() {
        init();
    }

    public static DelegateFactory getInstance() {
        return new DelegateFactory();
    }

    public Leader getLeader() {
        return leader;
    }
}
