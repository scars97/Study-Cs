package org.example.Java.exception.ex04;

import org.example.Java.exception.ex04.exception.ConnectExceptionV4;
import org.example.Java.exception.ex04.exception.NetworkClientExceptionV4;
import org.example.Java.exception.ex04.exception.SendExceptionV4;

public class NetworkServiceV4_2 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV4 client = new NetworkClientV4(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV4 e) {
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메시지: " + e.getMessage());
        } catch (NetworkClientExceptionV4 e) {
            System.out.println("[네트워크 오류] 메시지: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[알 수 없는 오류] 메시지: " + e.getMessage());
        } finally {
            client.disconnect();
        }
    }
}
