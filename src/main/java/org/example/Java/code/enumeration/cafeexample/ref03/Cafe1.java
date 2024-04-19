package org.example.Java.code.enumeration.cafeexample.ref03;

import static org.example.Java.code.enumeration.cafeexample.ref03.Menu.*;

public class Cafe1 {

    public static void main(String[] args) {

        System.out.println("A 주문금액 : " + AMERICANO.order());
        System.out.println("L 주문금액 : " + LATTE.order());
        System.out.println("M 주문금액 : " + MOCHA.order());
    }
}
