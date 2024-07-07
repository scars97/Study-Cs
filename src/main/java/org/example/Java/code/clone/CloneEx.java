package org.example.Java.code.clone;

public class CloneEx {

    public static void main(String[] args) {

        Member origin = new Member("성현", 28, new int[] {172, 60});

        Member cloned = origin.getMember();

        cloned.setSpec(new int[] {170, 58});

        System.out.println(origin.getSpec());
        System.out.println(cloned.getSpec());
    }
}
