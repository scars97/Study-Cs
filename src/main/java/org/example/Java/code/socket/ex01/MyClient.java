package org.example.Java.code.socket.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {

    public static void main(String[] args) {

        try (Socket socket = new Socket("127.0.0.1", 8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            out.println("안녕하세요. 서버!");

            String serverResponse = in.readLine();
            System.out.println("서버로부터의 응답: " + serverResponse);
        } catch (UnknownHostException e) {
            System.err.println("서버를 찾을 수 없습니다." + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O 오류 발생" + e.getMessage());
        }

    }
}
