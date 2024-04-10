package org.example.Java.enumeration.cafeexample.ex04;

import static org.example.Java.enumeration.cafeexample.ex04.Menu.*;

public class CoffeeService {

    public int order(Menu menu) {
        int price;

        if (menu.equals(AMERICANO)) {
            price = 700;
        } else if (menu.equals(LATTE)) {
            price = 1500;
        } else if (menu.equals(MOCHA)) {
            price = 1700;
        } else {
            price = 0;
            System.out.println("없는 메뉴입니다.");
        }

        return price;
    }

}
