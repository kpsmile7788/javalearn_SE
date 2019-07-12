package org.wm.server;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.wm.dao.UserDao;
import org.wm.dao.impl.UserDaoImpl;
import org.wm.entity.User;

public class Server2 {
	public static void main(String[] args) throws Exception {
		
		System.out.println("------------Already-------------");
		ServerSocket server = new ServerSocket(9999);
		while(true){
			Socket client = server.accept();
			
			new Thread(()->{
				ObjectInputStream ois = null;
				DataOutputStream dos = null;
				try {
					ois = new ObjectInputStream(client.getInputStream());
					User user = (User)ois.readObject();
					UserDao ud = new UserDaoImpl();

					String isExist = ud.isExist(user) ? "登陆成功！":"账号或密码错误！";
					
					System.out.println(client.getInetAddress().getHostAddress()+"请求访问。。"+ "账号为："+user.getUserName()+ "，密码为："+user.getPwd());
					
					dos = new DataOutputStream(client.getOutputStream());
					dos.writeUTF(isExist);
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					closeAll(dos,ois,client);
				}
			}).start();
		}
		
		
		
	}
	
	public static void closeAll(Closeable ...closeables){
		for (Closeable closeable : closeables) {
			if(closeable != null){
				try {
					closeable.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
