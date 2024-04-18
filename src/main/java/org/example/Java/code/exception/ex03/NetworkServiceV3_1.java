package org.example.Java.code.exception.ex03;

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
