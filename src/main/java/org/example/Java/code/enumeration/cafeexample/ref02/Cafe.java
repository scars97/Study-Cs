package org.example.Java.code.enumeration.cafeexample.ref02;

import static org.example.Java.code.enumeration.cafeexample.ref02.Menu.*;

public class Cafe {

    public static void main(String[] args) {
        CoffeeService coffee = new CoffeeService();

        int americano = coffee.order(AMERICANO);
        int latte = coffee.order(LATTE);
        int mocha = coffee.order(MOCHA);

        System.out.println("A 주문금액 : " + americano);
        System.out.println("L 주문금액 : " + latte);
        System.out.println("M 주문금액 : " + mocha);

    }
}
