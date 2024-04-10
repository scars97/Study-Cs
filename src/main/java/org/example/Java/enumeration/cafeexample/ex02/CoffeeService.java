package org.example.Java.enumeration.cafeexample.ex02;

public class CoffeeService {

    public int order(String coffee) {
        int price;

        if (coffee.equals(Menu.AMERICANO)) {
            price = 700;
        } else if (coffee.equals(Menu.LATTE)) {
            price = 1500;
        } else if (coffee.equals(Menu.MOCHA)) {
            price = 1700;
        } else {
            price = 0;
            System.out.println("없는 메뉴입니다.");
        }

        return price;
    }

}
