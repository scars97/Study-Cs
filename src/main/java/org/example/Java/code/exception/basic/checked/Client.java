package org.example.Java.code.exception.basic.checked;

public class Client {

    public void call() throws MyCheckedException{
        throw new MyCheckedException("ex");
    }
}
