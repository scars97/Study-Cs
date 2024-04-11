package org.example.Java.enumeration.cafeexample.ref03;

import static org.example.Java.enumeration.cafeexample.ref03.Menu.*;

public class Cafe2 {

    public static void main(String[] args) {

        Menu[] menus = values();
        for (Menu menu : menus) {
            printOrder(menu);
        }
    }

    private static void printOrder(Menu menu) {
        System.out.println(menu.name() + " 주문금액: " + menu.order());
    }
}
