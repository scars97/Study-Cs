package org.example.Java.exception.ex03;

public class NetworkServiceV3_2 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data);

        try {
            client.connect();
        } catch (NetworkClientExceptionV3 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
            return;
        }


        try {
            client.send(data);
        } catch (NetworkClientExceptionV3 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
            return;
        }

        client.disconnect();
    }
}
