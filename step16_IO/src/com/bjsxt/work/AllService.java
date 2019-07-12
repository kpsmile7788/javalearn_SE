package com.bjsxt.work;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AllService {

    private Scanner input = new Scanner(System.in);
    private static ArrayList<User> ul = new ArrayList<User>();
    private static String PATH = "E:\\userList.txt";
    private static File file = new File(PATH);

    static{
        if(!file.exists()){
            write();
        }
        read();
    }

    private static void read(){
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            ul = (ArrayList<User>)ois.readObject();
        } catch (Exception e) {
            System.err.println("读取文件出错！");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void write(){
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(ul);
        } catch (Exception e) {
            System.err.println("写入文件出错！");
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void mainMenu(){
        while (true){
            System.out.println("------1.注册 2.登陆 3.退出-----");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    regist();
                    continue;
                case 2:
                    login();
                    continue;
                case 3:
                    System.out.println("感谢您的使用！");
                    break;
                default :
                    System.out.println("输入有误，请重新输入！");
                    continue;
            }
            break;
        }
    }

    private void regist(){
        System.out.println("--------->注册页面");

        System.out.println("请输入用户名：");
        String uName = input.next();

        System.out.println("请输入密  码：");
        String pwd = input.next();

        User user = new User(uName,pwd);

        if(!isExists(user.getuName())){
            ul.add(user);
            write();
            System.out.println("注册成功！");
        } else {
            System.out.println("对不起，用户名已存在！");
        }
    }

    private boolean isExists(String uName) {
        for (User u: ul) {
            if(u.getuName().equals(uName)){
                return true;
            }
        }
        return false;
    }


    private void login(){

    }

}
