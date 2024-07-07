package org.example.Java.code.clone;

public class Member implements Cloneable {

    private String name;
    private int age;

    private int[] spec;

    public Member(String name, int age, int[] spec) {
        this.name = name;
        this.age = age;
        this.spec = spec;
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

    public Member getMember() {
        Member cloned = null;

        try {
            cloned = (Member) clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }

        return cloned;
    }
}
