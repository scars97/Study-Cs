package org.example.Java.code.exception.ex02;

public class NetworkClientV2 {

    private final String address;
    private boolean connectError;
    private boolean sendError;

    public NetworkClientV2(String address) {
        this.address = address;
    }

    public String connect() {

        if (connectError) {
            System.out.println(address + " 서버 연결 실패");
            return "connectError";
        }

        System.out.println(address + " 서버 연결 성공");
        return "success";
    }

    public String send(String data) {
        if (sendError) {
            System.out.println(address + " 서버에 데이터 전송 실패: " + data);
            return "sendError";
        }
        System.out.println(address + " 서버에 데이터 전송: " + data);
        return "success";
    }

    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }

    public void initError(String data) {
        if (data.contains("error1")) {
            connectError = true;
        }
        if (data.contains("error2")) {
            sendError = true;
        }
    }
}
