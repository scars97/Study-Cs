package org.example.Java.exception.ex03;

import java.util.Scanner;

public class MainV3 {

    public static void main(String[] args) {
        //NetworkServiceV3_1 networkService = new NetworkServiceV3_1();
        //NetworkServiceV3_2 networkService = new NetworkServiceV3_2();
        //NetworkServiceV3_3 networkService = new NetworkServiceV3_3();
        //NetworkServiceV3_4 networkService = new NetworkServiceV3_4();
        NetworkServiceV3_5 networkService = new NetworkServiceV3_5();

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
