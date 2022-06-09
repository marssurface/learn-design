package org.marsstudio.learn.design.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ClassLoaderUtils {

    private static Set<Class> primitiveSet = new HashSet<>();

    static {
        primitiveSet.add(Integer.class);
        primitiveSet.add(Long.class);
        primitiveSet.add(Float.class);
        primitiveSet.add(Byte.class);
        primitiveSet.add(Short.class);
        primitiveSet.add(Double.class);
        primitiveSet.add(Character.class);
        primitiveSet.add(Boolean.class);
    }

    /**
     * 获取当前ClassLoader
     *
     * @return
     */
    public static ClassLoader getCurrentClassLoader() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) {
            cl = ClassLoaderUtils.class.getClassLoader();
        }
        return cl == null ? ClassLoader.getSystemClassLoader() : cl;
    }

    /**
     * 获取当前ClassLoader
     *
     * @param clazz
     * @return
     */
    public static ClassLoader getClassLoader(Class<?> clazz) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader != null) {
            return loader;
        }
        if (clazz != null) {
            loader = clazz.getClassLoader();
            if (loader != null) {
                return loader;
            }
            return clazz.getClassLoader();
        }
        return ClassLoader.getSystemClassLoader();
    }

    /**
     * 根据类名加载Class
     *
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    public static Class forName(String className) throws ClassNotFoundException {
        return forName(className, true);
    }

    /**
     * 根据类名加载Class
     *
     * @param className
     * @param initialize
     * @return
     * @throws ClassNotFoundException
     */
    public static Class forName(String className, boolean initialize) throws ClassNotFoundException {
        return Class.forName(className, initialize, getCurrentClassLoader());
    }

    /**
     * 根据类名加载Clas
     *
     * @param className
     * @param cl
     * @return
     * @throws ClassNotFoundException
     */
    public static Class forName(String className, ClassLoader cl) throws ClassNotFoundException {
        return Class.forName(className, true, cl);
    }

    /**
     * 实例化一个对象(只检测默认构造函数，其它不管）
     *
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T newInstance(Class<T> clazz) throws Exception {
        if (primitiveSet.contains(clazz)) {
            return null;
        }
        if (clazz.isMemberClass() && Modifier.isStatic(clazz.getModifiers())) {
            Constructor constructorList[] = clazz.getDeclaredConstructors();
            Constructor defaultConstructor = null;
            for (Constructor con : constructorList) {
                if (con.getParameterTypes().length == 1) {
                    defaultConstructor = con;
                    break;
                }
            }

            if (defaultConstructor != null) {
                if (defaultConstructor.isAccessible()) {
                    return (T) defaultConstructor.newInstance(new Object[]{null});
                } else {
                    try {
                        defaultConstructor.setAccessible(true);
                        return (T) defaultConstructor.newInstance(new Object[]{null});
                    } finally {
                        defaultConstructor.setAccessible(true);
                    }
                }
            } else {
                throw new Exception("The " + clazz.getCanonicalName() + " has no default constructor!");
            }
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            if (constructor.isAccessible()) {
                throw new Exception("The " + clazz.getCanonicalName() + " has no default constructor!", e);
            } else {
                try {
                    constructor.setAccessible(true);
                    return constructor.newInstance();
                } finally {
                    constructor.setAccessible(false);
                }
            }
        }
    }

    /**
     * 获取参数类
     *
     * @param args
     * @return
     */
    public static Class<?>[] getClazzByArgs(Object[] args) {
        Class<?>[] parameterTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ArrayList) {
                parameterTypes[i] = List.class;
                continue;
            }
            if (args[i] instanceof LinkedList) {
                parameterTypes[i] = LinkedList.class;
                continue;
            }
            if (args[i] instanceof HashMap) {
                parameterTypes[i] = HashMap.class;
                continue;
            }
            if (args[i] instanceof Long) {
                parameterTypes[i] = Long.class;
                continue;
            }
            if (args[i] instanceof Double) {
                parameterTypes[i] = Double.class;
                continue;
            }
            if (args[i] instanceof TimeUnit) {
                parameterTypes[i] = TimeUnit.class;
                continue;
            }
            parameterTypes[i] = args[i].getClass();
        }
        return parameterTypes;
    }

    public Method getMethod(Class<?> classType, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        return classType.getMethod(methodName, parameterTypes);
    }
}
