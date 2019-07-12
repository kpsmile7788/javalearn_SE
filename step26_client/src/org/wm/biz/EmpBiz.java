package org.wm.biz;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.wm.entity.Emp;
import org.wm.entity.EmpEx;

public class EmpBiz {

	private Scanner input = new Scanner(System.in);
	
	private String hostName = "localhost";
	private int port = 9999;
	
	private Socket client = null;
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	private HashMap<String,Object> hm = null;
	
	public void mainMenu(){
		while(true){
			System.out.println("-------------欢迎使用本系统---q(-v-)p------------");
			System.out.println("1.新增员工 2.修改员工信息 3.员工离职 4.查询所有员工 5.根据姓名查询员工信息 0.退出");
			System.out.println("---------------------------------------------");
			int choice = input.nextInt();
			switch(choice){
				case 1:
					addNewOne();
					continue;
				case 2:
					updataMember();
					continue;
				case 3:
					deleteMember();
					continue;
				case 4:
					select();
					continue;
				case 5:
					continue;
				case 0:
					System.out.println("感谢您的使用！再见！");
					break;
				default:
					System.out.println("非法输入符，请重新输入0~5之间的数字选项！");
					continue;
			}
			break;
		}
		
	}

	private void deleteMember() {
		try {
			client = new Socket(hostName,port);
			oos = new ObjectOutputStream(client.getOutputStream());
			hm = new HashMap<String, Object>();
			hm.put("flag","delete");
			System.out.println("请输入离职员工的编号：");
			int number = input.nextInt();
			hm.put("number",number);
			oos.writeObject(hm);
			client.shutdownOutput();
			ois = new ObjectInputStream(client.getInputStream());
			boolean isDelete = (boolean)ois.readObject();
			client.shutdownInput();
			if (isDelete){
				System.out.println("员工信息已删除！");
			} else {
				System.out.println("未找到该编号离职员工信息！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updataMember() {
		try {
			client = new Socket(hostName,port);
			oos = new ObjectOutputStream(client.getOutputStream());
			hm = new HashMap<String, Object>();
			hm.put("flag","updata");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addNewOne() {
		try {
			client = new Socket(hostName,port);
			oos = new ObjectOutputStream(client.getOutputStream());
			hm = new HashMap<String,Object>();
			hm.put("flag","add");
			Emp emp = inputNew();
			hm.put("obj", emp);
			oos.writeObject(hm);
			client.shutdownOutput();
			ois = new ObjectInputStream(client.getInputStream());
			boolean result = (boolean)ois.readObject();
			client.shutdownInput();
			if(result){
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			closeAll(ois,oos,client);
		}
	}
	
	private Emp inputNew(){
		System.out.println("请输入该员工的编号：");
		int empNo = input.nextInt();
		System.out.println("请输入该员工的姓名：");
		String ename = input.next();
		System.out.println("请输入该员工的职位：");
		String job = input.next();
		System.out.println("请输入该员工的上级经理：");
		int mgr = input.nextInt();
		System.out.println("请输入该员工的入职时间：(输入格式为：yyyy-MM-dd)");
		String d = input.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("请输入该员工的薪水：");
		double sal = input.nextDouble();
		System.out.println("请输入该员工的津贴：");
		double comm = input.nextDouble();
		System.out.println("请输入该员工的部门编号：10.ACCOUNTING  20.RESEARCH  30.SALES  40.OPERATIONS");
		int deptno = input.nextInt();
		
		Emp emp = new Emp(empNo,ename,job,mgr,date,sal,comm,deptno);
		System.out.println("---------------------------");
		return emp;
	}

	private void select() {
		try {
			client = new Socket(hostName,port);
			oos = new ObjectOutputStream(client.getOutputStream());
			hm = new HashMap<String,Object>();
			hm.put("flag", "select");
			oos.writeObject(hm);
			client.shutdownOutput();
			
			ois = new ObjectInputStream(client.getInputStream());
			List<EmpEx> list = (List<EmpEx>) ois.readObject();
			client.shutdownInput();
			if(list.size()!=0){
				System.out.println("员工编号\t员工姓名\t员工职位\t上级经理\t入职时间\t薪水\t津贴\t部门编号\t部门名称\t部门所在地");
				for (EmpEx empEx : list) {
					System.out.println(empEx);
				}
			} else{
				System.out.println("查询失误！");
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeAll(ois,oos,client);
		}
	}

	private void closeAll(Closeable ...closeables ) {
		for (Closeable closeable : closeables) {
			if(closeable != null)
				try {
					closeable.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
