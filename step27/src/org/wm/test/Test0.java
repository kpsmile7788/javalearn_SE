package org.wm.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test0 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("org.wm.entity.Student");
        System.out.println(clazz.getName());
        System.out.println("--------------------------------");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c: constructors) {
            System.out.println(c);
        }
        System.out.println("------------------------------------");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields){
            System.out.println(f);
        }
        System.out.println("------------------------------------");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods){
            System.out.println(m.getName());
        }
    }
}
