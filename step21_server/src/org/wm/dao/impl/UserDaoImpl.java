package org.wm.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.wm.dao.UserDao;
import org.wm.entity.User;

public class UserDaoImpl implements UserDao{

	private static File file = new File("user.txt");
	private static List<User> ul = new ArrayList<User>();
	
	static{
		if(!file.exists()){
			User user = new User("admin","admin");
			ul.add(user);
			write();
		}
		read();
	}
	
	private static void read(){
		ObjectInputStream ois = null;
		try {
			ois =  new ObjectInputStream(new FileInputStream(file));
			ul = (List<User>)ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		try {
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void write(){
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(ul);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isExist(User user) {
		read();
		if(ul.contains(user)){
			return true;
		}
		return false;
	}

}
