package org.example.Java.object.tostring;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Dog {

    private String dogName;
    private int age;

    public Dog(String dogName, int age) {
        this.dogName = dogName;
        this.age = age;
    }

    @Override
    public String toString() {
        /*return "Dog{" +
                "dogName='" + dogName + '\'' +
                ", age=" + age +
                '}';*/

        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append("dogName", dogName)
                .append("age", age)
                .toString();
    }
}
