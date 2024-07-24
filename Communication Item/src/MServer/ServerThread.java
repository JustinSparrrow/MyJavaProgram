package MServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ServerThread implements Runnable {
    private List<User> userList;
    private Socket socket;
    private OutputStream os;
    private InputStream is;

    public ServerThread(Socket socket, List<User> userList) {
        this.socket = socket;
        this.userList = userList;
        try {
            os = socket.getOutputStream();
            is = socket.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            String msg = readMsg(is);
            System.out.println("Client:"+msg);

            // 消息内容：消息头:消息内容
            String[] msgArr = msg.split(":");

            // 私聊
            if (msgArr[0].equals("")){

            }

            // 群聊
            for(User user: userList){
                if(user.getSocket() != socket){
                    OutputStream s_os = user.getSocket().getOutputStream();
                    s_os.write((user.get_id() + msg).getBytes());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readMsg(InputStream is) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int b;
        int maxLength = 1024;   // 设置最大消息长度
        int count = 0;
        while ((b = is.read()) != -1 && b != 13){
            // 拼接一条聊天消息
            stringBuilder.append((char)b);
            count++;
            if(count >= maxLength){
                System.out.println("消息太长！");
                // 避免消息过长导致内存溢出
                break;
            }
        }
        return stringBuilder.toString();
    }
}
