package MClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int port = 66;
        new Client().createClient(serverAddress, port);
    }

    public void createClient(String serverAddress, int port){
        try {
            Socket client = new Socket(serverAddress, port);
            System.out.println("连接到服务器！");

            // 获取输入输出流
            OutputStream os = client.getOutputStream();
            InputStream is = client.getInputStream();

            // 从服务器接收数据
            String message = readMsg(is);
            System.out.println("server:" + message);

            // 发送连接成功消息给服务器
            String clientMsg = client+"The server is connected successfully. Procedure\r";
            os.write(clientMsg.getBytes());
            os.flush();

            // while循环卡一下
            while (true){

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readMsg(InputStream is) throws IOException {
//        System.out.println("test");
        StringBuilder stringBuilder = new StringBuilder();
        int b;
        int maxLength = 1024; // 设置最大消息长度
        int count = 0;

        while ((b = is.read()) != -1 && b != 13) { // 读取直到遇到回车字符或达到最大长度
            stringBuilder.append((char) b);
            count++;
            if (count >= maxLength) {
                System.out.println("消息太长!");
                break; // 避免消息过长导致内存溢出
            }
        }

        return stringBuilder.toString();
    }
}
