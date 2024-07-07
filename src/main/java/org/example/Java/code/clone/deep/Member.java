package org.example.Java.code.clone.deep;

import org.example.Java.code.clone.Address;

import java.util.Arrays;

public class Member implements Cloneable {

    private String name;
    private int age;

    private int[] spec;
    private Address address;

    public Member(String name, int age, int[] spec, Address address) {
        this.name = name;
        this.age = age;
        this.spec = spec;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getSpec() {
        return spec;
    }

    public void setSpec(int[] spec) {
        this.spec = spec;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        // 기본 타입 얕은 복사
        Member cloned = (Member) super.clone();

        // 참조 타입 깊은 복사
        cloned.spec = Arrays.copyOf(this.spec, this.spec.length);
        cloned.address = new Address(this.address.getCity());

        return cloned;
    }

    public Member deepCopy() {
        Member cloned = null;

        try {
            cloned = (Member) clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }

        return cloned;
    }
}
