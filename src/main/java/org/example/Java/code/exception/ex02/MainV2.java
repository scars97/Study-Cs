package org.example.Java.code.exception.ex02;

import java.util.Scanner;

public class MainV2 {

    public static void main(String[] args) {
        //NetworkServiceV2 networkService = new NetworkServiceV2();
        //NetworkServiceV2_1 networkService = new NetworkServiceV2_1();
        NetworkServiceV2_2 networkService = new NetworkServiceV2_2();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("전송할 문자: ");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            }

            networkService.sendMessage(input);
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료합니다.");
    }
}
