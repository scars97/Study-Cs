package org.example.Java.enumeration.cafeexample.ref02;

public enum Menu {

    AMERICANO(700),
    LATTE(1500),
    MOCHA(1800);

    private final int price;

    Menu(int price) {
        this.price = price;
    }

    public int orderPrice() {
        return price;
    }
}


