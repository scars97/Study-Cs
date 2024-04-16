package org.example.Java.exception.ex03;

public class NetworkServiceV3_4 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
        } catch (NetworkClientExceptionV3 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        }

        // NetworkClientExceptionV3 가 아닌 다른 예외가 발생할 시 실행되지 않는다.
        client.disconnect();
    }
}
