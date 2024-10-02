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
        // 사용자가 생성한 주문이므로 사용자 유효성 검사가 가장 먼저 이뤄져야 함.
        // 사용자 정보가 없으면 주문 데이터 자체가 성립 되지 않음.
        if (order.hasCustomerInfo()) {

            if (order.getItems().size() == 0) {
                System.out.println("주문 항목이 없습니다.");
                return false;
            }

            // 부정 연산자 대신 부등호 방향 변경
            // order.getTotalPrice() > 0 조건은 정상이므로 검사 제외
            if (order.getTotalPrice() < 0) {
                System.out.println("올바르지 않은 총 가격입니다.");
                return false;
            }

            return true;
        }
        
        System.out.println("사용자 정보가 없습니다.");
        return false;
    }
}
