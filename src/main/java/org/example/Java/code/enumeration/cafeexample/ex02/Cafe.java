package org.example.Java.code.enumeration.cafeexample.ex02;

public class Cafe {

    public static void main(String[] args) {
        CoffeeService coffee = new CoffeeService();

        int americano = coffee.order(Menu.AMERICANO);
        int latte = coffee.order(Menu.LATTE);
        int mocha = coffee.order(Menu.MOCHA);

        System.out.println("A 주문금액 : " + americano);
        System.out.println("L 주문금액 : " + latte);
        System.out.println("M 주문금액 : " + mocha);
    }
}
