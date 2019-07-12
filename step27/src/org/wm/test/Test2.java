package org.wm.test;

import org.wm.entity.Human;
import org.wm.factory.HumanFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test2 {
    public static void main(String[] args) {
        File file = new File("a.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String skin = properties.getProperty("yellow");
        Human human = HumanFactory.createHuman(skin);
        human.cry();
        human.laugh();
        human.talk();

    }
}
