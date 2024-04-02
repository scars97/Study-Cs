package org.example.Java.immutable.address;

public class ReferenceMain {

    public static void main(String[] args) {
        Address add1 = new Address("서울");
        Address add2 = add1;

        System.out.println("add1 = " + add1);
        System.out.println("add2 = " + add2);

        add2.setValue("부산");
        System.out.println("add1 = " + add1.getValue());
        System.out.println("add2 = " + add2.getValue());
    }
}
