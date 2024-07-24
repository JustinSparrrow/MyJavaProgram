package MServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// 自定义服务端
public class Server {

    public static void main(String[] args) {
        new Server().createServer();
    }

    // 创建服务器
    public void createServer(){
        try  {
            ServerSocket server = new ServerSocket(66);
            System.out.println("启动服务器...");

            // 保存上线好友
            int userCount = 0;
            List<User> userList = new ArrayList<>();
            userCount++;

            // 持续监听客户端信息
            while (true) {
                // 阻塞监听连接过来的客户端
                Socket socket = server.accept();
                User user = new User(userCount, "test", "test", socket, true);
                userList.add(user);

                // 获取输入，输出流
                OutputStream os = socket.getOutputStream();
                InputStream is = socket.getInputStream();

//                String message = "您已成功连接到服务器。\r";
                String message = "You have successfully connected to the server.\r";
                sendMsg(os, message);
//                System.out.println("发送消息成功！");

                // 启动线程，与客户通信
                ServerThread st = new ServerThread(socket, userList);
                new Thread(st).start();
            }
//            // 关闭通信流
//            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 读取客户端数据
    // StringBuffer StringBuilder String

    public void sendMsg(OutputStream os, String message) throws IOException {
        os.write(message.getBytes());
        os.flush();
    }
}
