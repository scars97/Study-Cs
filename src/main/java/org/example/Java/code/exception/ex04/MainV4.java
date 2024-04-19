package org.example.Java.code.exception.ex04;


import java.util.Scanner;

public class MainV4 {

    public static void main(String[] args) {
        //NetworkServiceV4_1 networkService = new NetworkServiceV4_1();
        NetworkServiceV4_2 networkService = new NetworkServiceV4_2();

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
