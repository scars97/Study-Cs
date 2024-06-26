package org.example.Java.code.object.poly;

public class ObjectExample {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();
        System.out.println(car);

        action(dog);
        action(car);
    }

    public static void action(Object obj) {
        if (obj instanceof Dog) {
            ((Dog) obj).sound();
        } else if (obj instanceof Car) {
            ((Car) obj).move();
        }
    }
}
