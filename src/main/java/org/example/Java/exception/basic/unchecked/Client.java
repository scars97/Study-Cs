package org.example.Java.exception.basic.unchecked;

public class Client {

    public void call() {
        throw new MyUncheckedException("ex");
    }
}
