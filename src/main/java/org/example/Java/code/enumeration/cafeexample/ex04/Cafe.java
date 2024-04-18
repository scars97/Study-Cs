package org.example.Java.code.enumeration.cafeexample.ex04;

import java.util.Arrays;

import static org.example.Java.code.enumeration.cafeexample.ex04.Menu.*;

public class Cafe {

    public static void main(String[] args) {
        CoffeeService coffee = new CoffeeService();

        int americano = coffee.order(AMERICANO);
        int latte = coffee.order(LATTE);
        int mocha = coffee.order(MOCHA);

        System.out.println("A 주문금액 : " + americano);
        System.out.println("L 주문금액 : " + latte);
        System.out.println("M 주문금액 : " + mocha);

        Menu[] values = values();
        Menu valueOf = valueOf("AMERICANO");
        String name = valueOf.name();
        int ordinal = valueOf.ordinal();
        System.out.println("values = " + Arrays.toString(values));
        System.out.println("valueOf = " + valueOf);
        System.out.println("name = " + name);
        System.out.println("ordinal = " + ordinal);
    }
}
