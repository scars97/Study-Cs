package org.example.Java.code.clone.deep;

import org.example.Java.code.clone.Address;

public class DeepCopyEx {

    public static void main(String[] args) {

        Member origin = new Member("성현", 28, new int[] {172, 60}, new Address("서울"));

        Member cloned = origin.deepCopy();

        cloned.getSpec()[0] = 100;
        cloned.getAddress().setCity("하남");

        System.out.println(origin.getSpec()[0]);
        System.out.println(cloned.getSpec()[0]);

        System.out.println(origin.getAddress().getCity());
        System.out.println(cloned.getAddress().getCity());
    }
}
