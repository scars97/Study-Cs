package org.example.Java.code.exception.ex04;

import org.example.Java.code.exception.ex04.exception.ConnectExceptionV4;
import org.example.Java.code.exception.ex04.exception.SendExceptionV4;

public class NetworkClientV4 {

    private final String address;
    private boolean connectError;
    private boolean sendError;

    public NetworkClientV4(String address) {
        this.address = address;
    }

    public void connect() throws ConnectExceptionV4 {
        if (connectError) {
            throw new ConnectExceptionV4(address, address + " 서버 연결 실패");
        }

        System.out.println(address + " 서버 연결 성공");
    }

    public void send(String data) throws SendExceptionV4 {
        if (sendError) {
            throw new SendExceptionV4(data, address + " 서버에 데이터 전송 실패: " + data);
            //throw new RuntimeException("ex");
        }

        System.out.println(address + " 서버에 데이터 전송: " + data);
    }

    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }

    public void initError(String data) {
        if (data.contains("error1")) {
            this.connectError = true;
        }
        if (data.contains("error2")) {
            this.sendError = true;
        }
    }
}
