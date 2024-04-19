package org.example.Java.code.exception.basic.unchecked;

public class Client {

    public void call() {
        throw new MyUncheckedException("ex");
    }
}
