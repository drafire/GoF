package com.example.gof.delegate;

import com.example.gof.Util.DIUtil;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.List;

public class DelegateFactory extends DIUtil<Target, TargetPolicy> {
    @Override
    public List<Class<? extends Target>> getList(File[] resource) {
        return null;
    }

    @Override
    public TargetPolicy handleAnnotation(Class<? extends Target> clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        if (annotations == null || annotations.length < 1) {
            return null;
        }
        for (Annotation annotation:
                annotations) {
            if(annotation instanceof TargetPolicy){
                return (TargetPolicy)annotation;
            }
        }
        return null;
    }
}
