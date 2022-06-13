package org.marsstudio.learn.design;

/**
 * 懒汉模式 线程安全
 */
public class Singleton_02 {

    private static Singleton_02 instance;

    private Singleton_02() {
    }

    public static synchronized Singleton_02 getInstance() {
        if (null != instance) {
            return instance;
        }
        instance = new Singleton_02();
        return instance;
    }
}
