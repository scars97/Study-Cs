package org.example.etc.study.inflearn.readablecode.mission;

import java.util.List;

public class RefactorOfDay4 {

    public static void main(String[] args) {
        List<String> items = List.of("product1", "product2");
        int totalPrice = 2000;
        boolean customerInfo = true;

        Order order = new Order(items, totalPrice, customerInfo);
        System.out.println(validateOrder(order));
    }

    static boolean validateOrder(Order order) {
        if (order.getItems().size() == 0) {
            System.out.println("주문 항목이 없습니다.");
            return false;
        }

        if (order.getTotalPrice() > 0) {
            if (!order.hasCustomerInfo()) {
                System.out.println("사용자 정보가 없습니다.");
                return false;
            }
            return true;
        }

        if (!(order.getTotalPrice() > 0)) {
            System.out.println("올바르지 않은 총 가격입니다.");
            return false;
        }

        return true;
    }
}
