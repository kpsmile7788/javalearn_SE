package org.wm.thread;

import org.wm.util.CloseUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SendRun implements Runnable {

    private DataOutputStream dos = null;
    private boolean isStop = false;
    private BufferedReader br =  null;

    public SendRun(Socket client) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            isStop = true;
            CloseUtil.closeAll(dos);
        }
    }

    private void sendMessage(){
        try {
            dos.writeUTF(Thread.currentThread().getName()+"-->说："+br.readLine());
            dos.flush();
        } catch (IOException e) {
            isStop = true;
            CloseUtil.closeAll(br,dos);
        }
    }

    @Override
    public void run() {
        while (!isStop){
            this.sendMessage();
        }
    }
}
