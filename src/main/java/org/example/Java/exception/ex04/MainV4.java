package org.example.Java.exception.ex04;


import org.example.Java.exception.ex03.NetworkServiceV3_1;
import org.example.Java.exception.ex03.NetworkServiceV3_5;

import java.io.BufferedReader;
import java.util.Scanner;

public class MainV4 {

    public static void main(String[] args) {
        NetworkServiceV4_1 networkService = new NetworkServiceV4_1();

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
