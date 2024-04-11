package org.example.Java.enumeration.cafeexample.ref01;

public class Menu {

    public static final Menu AMERICANO = new Menu(700);
    public static final Menu LATTE = new Menu(1500);
    public static final Menu MOCHA = new Menu(1800);

    private final int price;

    public Menu(int price) {
        this.price = price;
    }

    public int orderPrice() {
        return price;
    }
}


