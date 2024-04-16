package org.example.Java.exception.ex03;

import org.example.Java.exception.ex02.NetworkClientV2;

public class NetworkServiceV3_1 {

    public void sendMessage(String data) throws NetworkClientExceptionV3 {
        String address = "http://example.com";
        NetworkClientV3 client = new NetworkClientV3(address);
        client.initError(data);

        client.connect();
        client.send(data);
        client.disconnect();
    }
}
