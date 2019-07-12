package org.wm.thread;

import org.wm.dao.EmpDao;
import org.wm.dao.impl.EmpDaoImpl;
import org.wm.entity.Emp;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class EmpThread implements Runnable {

    private Socket client;

    public EmpThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            ois = new ObjectInputStream(client.getInputStream());
            oos = new ObjectOutputStream(client.getOutputStream());
            HashMap<String,Object> hm = (HashMap<String,Object>) ois.readObject();
            client.shutdownInput();

            EmpDao ed = new EmpDaoImpl();
            String opertion = (String) hm.get("flag");
            System.out.println(Thread.currentThread().getName()+"进行--->"+opertion+"操作！");
            if ("select".equals(opertion)){
                //查找所有人
                oos.writeObject(ed.getAll2());

            } else if ("add".equals(opertion)){
                //添加新员工
                Emp emp = (Emp)hm.get("obj");
                boolean isInsert = ed.insert(emp)>0 ? true : false;
                oos.writeObject(isInsert);

            } else if ("delete".equals(opertion)){
                //删除员工（员工离职）
                int number = (int)hm.get("number");
                oos.writeObject(ed.delete(number)>0?true:false);

            }
            client.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeAll(oos,ois,client);
        }
    }
    private static void closeAll(Closeable... closeables) {
        for (Closeable clo:closeables
        ) {
            if (clo !=null){
                try {
                    clo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
