package org.example.etc.study.inflearn.readablecode.mission;

import java.util.List;

public class RefactorOfDay4 {

    public static void main(String[] args) {
        List<String> items = List.of("product1", "product2");
        int totalPrice = 2000;
        boolean customerInfo = true;

        Order order = new Order(items, totalPrice, customerInfo);

    }
}
