package org.example.etc.study.inflearn.readablecode.mission.day04;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("customer1");
        List<String> items = List.of("product1", "product2");
        long totalPrice = 2000L;

        Order order = new Order(customer, items, totalPrice);

        System.out.println(validateOrder(order));
    }

    // 사용자가 생성한 주문이므로 사용자 유효성 검사가 가장 먼저 이뤄져야 함.
    // 사용자 정보가 없으면 주문 데이터 자체가 성립 되지 않음.
    static boolean validateOrder(Order order) {
        if (order.isMissingCustomerInfo()) {
            System.out.println("사용자 정보가 존재하지 않습니다.");
            return false;
        }


        if (order.isEmptyItems()) {
            System.out.println("주문 항목이 없습니다.");
            return false;
        }

        if (order.isIncorrectTotalPrice()) {
            System.out.println("올바르지 않은 총 가격입니다.");
            return false;
        }

        return true;
    }
}
