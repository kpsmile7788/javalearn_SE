package org.wm.test;

import org.wm.entity.Student;

import java.lang.reflect.*;
import java.util.Properties;

public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class clazz = Class.forName("org.wm.entity.Student");
        Constructor constructor = clazz.getConstructor();
        Student o = (Student) constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (Field f:fields) {
            System.out.println(f);
        }
        String name = fields[0].getName();
        String setMethod = "set"+Character.toUpperCase(name.charAt(0))+name.substring(1);
        String getMethod = "get"+Character.toUpperCase(name.charAt(0))+name.substring(1);
        System.out.println(setMethod+"\t"+getMethod);

        Method sMethod = clazz.getMethod(setMethod,String.class);
        sMethod.invoke(o,"aaa");
        Method gMethod = clazz.getMethod(getMethod);
        System.out.println(gMethod.invoke(o));
    }
}
