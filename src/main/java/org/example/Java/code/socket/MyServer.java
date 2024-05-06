package org.example.Java.code.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("서버가 시작되었습니다. 클라이언트의 연결을 기다립니다.");

            // 클라이언트 연결 기다림
            Socket clientSocket = serverSocket.accept();
            System.out.println("클라이언트가 연결되었습니다.");

            // 클라이언트로부터 데이터 수신
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String clientMessage = in.readLine();
            System.out.println("클라이언트: " + clientMessage);

            // 클라이언트에게 응답
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("서버로부터 응답: 메시지를 받았습니다.");

            // 소켓과 스트림을 닫음
            in.close();
            out.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
