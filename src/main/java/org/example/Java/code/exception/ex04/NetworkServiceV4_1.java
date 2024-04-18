package org.example.Java.code.exception.ex04;

import org.example.Java.code.exception.ex04.exception.ConnectExceptionV4;
import org.example.Java.code.exception.ex04.exception.SendExceptionV4;

public class NetworkServiceV4_1 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV4 client = new NetworkClientV4(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV4 e) {
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메시지: " + e.getMessage());
        } catch (SendExceptionV4 e) {
            System.out.println("[전송 오류] 전송 데이터 : " + e.getSendData() + ", 메시지: " + e.getMessage());
        } finally {
            client.disconnect();
        }
    }
}
