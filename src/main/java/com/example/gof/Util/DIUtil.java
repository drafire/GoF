package com.example.gof.Util;

import java.io.File;
import java.io.FileFilter;
import java.net.URISyntaxException;
import java.util.List;

/**
 * 获取依赖注入工具类
 */
public abstract class DIUtil<T> {
    private ClassLoader loader = getClass().getClassLoader();

    /**
     * 获取策略类列表
     * @param packageName
     * @return
     */
    public List<Class<? extends T>> getDelegateList(String packageName) {
        List<Class<? extends T>> list;
        File[] resource = getResources(packageName);
        list = getList(resource);
        return list;
    }

    //获取包下的所有class类
    private File[] getResources(String packageName) {
        try {
            File file = new File(loader.getResource(packageName.replace(".", "/")).toURI());
            return file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    boolean status=false;
                    if (pathname.getName().endsWith(".class")) { //只扫描class
                        status= true;
                    }
                    return status;
                }
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }

    public abstract List<Class<? extends T>> getList(File[] resource);
}
