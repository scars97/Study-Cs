package org.example.Java.code.socket.ex02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {

    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket();
            System.out.println("서버에 연결을 요청합니다.");
            socket.connect(new InetSocketAddress("localhost", 8080));
            System.out.println("서버와 연결되었습니다.");

            byte[] bytes = null;
            String message = null;

            OutputStream os = socket.getOutputStream();
            message = "Hello Server";
            bytes= message.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("데이터 보내기 성공");

            InputStream is = socket.getInputStream();
            bytes = new byte[100];
            int readByteCount = is.read(bytes);
            message = new String(bytes, 0, readByteCount, "UTF-8");
            System.out.println("데이터 받기 성공: " + message);

            os.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!socket.isClosed()) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
