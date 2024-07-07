package org.example.Java.code.clone.shallow;

import org.example.Java.code.clone.Address;

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

    public Member shallowCopy() {
        Member cloned = null;

        try {
            cloned = (Member) clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }

        return cloned;
    }
}
