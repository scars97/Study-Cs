package org.example.Java;

public class JavaMain {
    public static void main(String[] args) throws Exception{
        Class cls = Class.forName("java.lang.String");

        System.out.println(cls.getName());
    }
}
