package org.wm.factory;

import org.wm.entity.Human;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HumanFactory {
    public static Human createHuman(String cname){

        Human human = null;
        try {
            Class clazz = Class.forName(cname);
            Constructor constructor = clazz.getConstructor();
            human = (Human) constructor.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return human;
    }
}
