package org.example.Java.code.exception.ex03;

public class NetworkServiceV3_3 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
            client.disconnect();
        } catch (NetworkClientExceptionV3 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        }
    }
}
