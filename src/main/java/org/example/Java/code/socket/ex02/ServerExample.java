package org.example.Java.code.socket.ex02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 8080));
            while (true) {
                System.out.println("클라이언트의 연결을 기다립니다.");
                // 클라이언트가 연결을 요청하기 전까지 블로킹된다.
                // 연결을 요청하면 통신할 Socket을 만들고 리턴한다. -> 연결 수락
                Socket socket = serverSocket.accept();
                InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("연결을 수락합니다 " + socketAddress.getHostName());

                byte[] bytes = null;
                String message = null;

                InputStream is = socket.getInputStream();
                bytes = new byte[100];
                int readByteCount = is.read(bytes);
                message = new String(bytes, 0, readByteCount, "UTF-8");
                System.out.println("데이터 받기 성공: " + message);

                OutputStream os = socket.getOutputStream();
                message = "Hello Client";
                bytes= message.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("데이터 보내기 성공");

                is.close();
                os.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
