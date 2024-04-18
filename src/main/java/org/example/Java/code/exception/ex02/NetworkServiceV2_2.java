package org.example.Java.code.exception.ex02;

public class NetworkServiceV2_2 {

    public void sendMessage(String data) {
        String address = "http://example.com";
        NetworkClientV2_1 client = new NetworkClientV2_1(address);
        client.initError(data);

        String connectResult = client.connect();
        if (isError(connectResult)) {
            System.out.println("[네트워크 오류 발생] 오류 코드: " + connectResult);
        } else {
            String sendResult = client.send(data);
            if (isError(sendResult)) {
                System.out.println("[네트워크 오류 발생] 오류 코드: " + sendResult);
            }
        }

        client.disconnect();
    }

    private boolean isError(String resultCode) {
        return !resultCode.equals("success");
    }
}
