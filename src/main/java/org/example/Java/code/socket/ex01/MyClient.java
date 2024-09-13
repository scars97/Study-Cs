package org.example.Java.code.socket.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class MyClient {

    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out;
        BufferedReader in;

        try {
            SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080); // 주소 지정
            // 소켓 생성
            socket = new Socket();
            // 읽기 타임아웃 설정 - 응답없으면 SocketTimeoutException 발생
            socket.setSoTimeout(5000);
            // 지연(linger) 옵션을 설정. true와 0을 사용했기 때문에 소켓이 닫힐 때 보류 중인 데이터를 지체 없이 바로 닫는다.
            // 일반적으로는 linger 옵션은 소켓을 닫을 때 데이터를 모두 보낸 후 연결을 닫는 시간을 조정한다.
            socket.setSoLinger(true, 0);
            // 소켓 주소 재사용 허용
            socket.setReuseAddress(true);
            // 소켓 연결 시도
            socket.connect(socketAddress, 2000);


            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("안녕하세요. 서버!");

            String serverResponse = in.readLine();
            System.out.println("서버로부터의 응답: " + serverResponse);

            in.close();
            out.close();
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("서버를 찾을 수 없습니다." + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O 오류 발생" + e.getMessage());
        }

    }
}
