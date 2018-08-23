package com.example.gof.Util;

import java.io.File;
import java.io.FileFilter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取依赖注入工具类
 */
public abstract class DIUtil<T, E> {
    private ClassLoader loader = getClass().getClassLoader();

    private List<Class<? extends T>> list;   //策略类列表

    //获取包下的所有class类
    public File[] getResources(String packageName) {
        try {
            File file = new File(loader.getResource(packageName.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".class")) { //只扫描class
                        return true;
                    }
                    return false;
                }
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }

    public List<Class<? extends T>> init(String packageName) {
        list = new ArrayList<>();
        File[] resource = getResources(packageName);
        list = getList(resource);
        return list;
    }

    public abstract List<Class<? extends T>> getList(File[] resource);

    public abstract E handleAnnotation(Class<? extends T> clazz);
}
