该程序采用C/S架构
（程序虽然表面上是一个客户端接收其他所有客户端发送过来的消息，其实是每个客户端只对服务器端进行通讯）。
通过IO流进行数据交换。


client:
    建立一个socket套接字连接服务器端。
    客户端创立两个线程，一个线程负责接收消息，另一个负责发送消息。


server:
    每个客户端连上服务端后会在服务端建立一个自定义的管道（MyChannel）<该管道负责拉取和发送消息>
    服务端拥有一个储存所有管道的容器。（如list） List<MyChannel> userList = new ArrayList<MyChannel>();
    /**
        每个管道内各有一个DataInputStream和DataOutputStream,这两个流都是属于服务器
        他们分别连接的是客户端的DataOutputStream和DataInputStream
    */

    服务器端只需接收到某一个客户端的消息后把这条消息发送给其他客户端（
        for(A a : userlist){
            if(this==a)
                continue;
            a.send()
        }

    ）。

