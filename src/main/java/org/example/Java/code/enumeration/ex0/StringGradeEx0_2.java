package org.example.Java.code.enumeration.ex0;

public class StringGradeEx0_2 {

    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        
        // 존재하지 않는 등급
        int vip = discountService.discount("VIP", price);
        System.out.println("vip = " + vip);

        // 오타
        int diamondd = discountService.discount("DIAMONDD", price);
        System.out.println("diamondd = " + diamondd);

        // 소문자 입력
        int gold = discountService.discount("gold", price);
        System.out.println("gold = " + gold);
    }
}
