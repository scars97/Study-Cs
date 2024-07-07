package org.example.Java.code.clone;

public class CloneEx {

    public static void main(String[] args) {

        Member origin = new Member("성현", 28, new int[] {172, 60});

        Member cloned = origin.getMember();

        cloned.getSpec()[0] = 100;

        System.out.println(origin.getSpec()[0]);
        System.out.println(cloned.getSpec()[0]);
    }
}
