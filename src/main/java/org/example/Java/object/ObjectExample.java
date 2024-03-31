package org.example.Java.object;

import org.example.Java.object.poly.Car;
import org.example.Java.object.poly.Dog;

public class ObjectExample {

    public static void main(String[] args) {
        Object dog = new Dog();
        Object car = new Car();
        System.out.println(car);

        action(dog);
        action(car);
    }

    public static void action(Object obj) {
        if (obj instanceof Dog dog) {
            dog.sound();
        } else if (obj instanceof Car car) {
            car.move();
        }
    }
}
