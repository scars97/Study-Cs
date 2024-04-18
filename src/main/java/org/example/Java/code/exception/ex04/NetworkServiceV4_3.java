package org.example.Java.code.exception.ex04;

import org.example.Java.code.exception.ex04.exception.ConnectExceptionV4;
import org.example.Java.code.exception.ex04.exception.SendExceptionV4;

public class NetworkServiceV4_3 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV4 client = new NetworkClientV4(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV4 | SendExceptionV4 e) { // 공통 부모의 기능만 사용 가능
            System.out.println("[연결 또는 전송 오류] 주소: , 메시지: " + e.getMessage());
        } finally {
            client.disconnect();
        }
    }
}
