package org.example.Java.exception.ex03;

public class NetworkClientV3 {

    private final String address;
    private boolean connectError;
    private boolean sendError;

    public NetworkClientV3(String address) {
        this.address = address;
    }

    public void connect() throws NetworkClientExceptionV3 {
        if (connectError) {
            throw new NetworkClientExceptionV3("connectError", address + " 서버 연결 실패");
        }

        System.out.println(address + " 서버 연결 성공");
    }

    public void send(String data) throws NetworkClientExceptionV3 {
        if (sendError) {
            throw new NetworkClientExceptionV3("sendError", address + " 서버에 데이터 전송 실패: " + data);
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
