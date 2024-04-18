package org.example.Java.code.enumeration.cafeexample.ex03;

public class CoffeeService {

    public int order(Menu menu) {
        int price;

        if (menu.equals(Menu.AMERICANO)) {
            price = 700;
        } else if (menu.equals(Menu.LATTE)) {
            price = 1500;
        } else if (menu.equals(Menu.MOCHA)) {
            price = 1700;
        } else {
            price = 0;
            System.out.println("없는 메뉴입니다.");
        }

        return price;
    }

}
