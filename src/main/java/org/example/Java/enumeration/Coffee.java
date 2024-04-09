package org.example.Java.enumeration;

public class Coffee {

    private int price;

    public int order(String coffee) {
        if (coffee.equals("AMERICANO")) {
            price = 700;
        } else if (coffee.equals("LATTE")) {
            price = 1500;
        } else if (coffee.equals("MOCHA")) {
            price = 1700;
        } else {
            price = 0;
            System.out.println("없는 메뉴입니다.");
        }

        return price;
    }

}
