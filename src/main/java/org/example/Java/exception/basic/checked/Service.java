package org.example.Java.exception.basic.checked;

public class Service {

    Client client = new Client();

    public void callCatch() {

        try {
            client.call();
        } catch (MyCheckedException e) {
            System.out.println("예외 처리, message= " + e.getMessage());
        }
        System.out.println("정상 흐름");
    }

    public void catchThrow() throws MyCheckedException{
        client.call();
    }
}
