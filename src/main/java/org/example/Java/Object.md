# Object

---

모든 클래스의 최상위 부모 클래스는 항상 Object 클래스이다.

클래스에 상속 받을 부모 클래스가 없다면 묵시적으로 Object 클래스를 상속받는다.
```java
// 묵시적으로 Object 클래스를 상속
public class Parent extends Object{
    
    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}

// Object가 아닌 Parent 상속
public class Child extends Parent{

    public void childMethod() {
        System.out.println("Child.childMethod");
    }
}

public class objectMain {

    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod();
        child.parentMethod();

        // toString()은 Object 클래스의 메서드
        String string = child.toString();
        System.out.println(string);
    }
}
```

### 자바에서 Object 클래스가 최상위 부모 클래스인 이유는 뭘까
- 공통 기능 제공
  - 프로그래밍이 단순화되고, 일관성을 가진다.
- 다형성의 기본 구현
  - Object는 모든 객체를 참조할 수 있다.
  - 모든 자바 객체는 Object 타입으로 처리될 수 있다.

### Object의 다형성
- Object는 모든 타입의 부모이다. 그러므로 자식 타입을 참조할 수 있다.
```java
// 다형적 참조 - 부모 타입의 변수가 자식 인스턴스를 참조할 수 있는 것
Object dog = new Dog();
Object car = new Car();
```
- 하지만 자식 타입의 메서드는 사용이 불가능하다.
- 위 코드의 dog, car는 Object 타입이기 때문인데
- Object에서는 자식 타입의 메서드를 찾을 수 없다.
- 메서드가 없다면 부모 클래스로 올라가 찾을 수 있지만
- Object는 최상위 부모 클래스이므로 더 올라가서 찾을 수 없다.
- 만약 Dog 인스턴스의 메서드를 호출하려면 다운 캐스팅을 해야한다.
```java
if (obj instanceof Dog dog) {
    dog.sound();
}
```

**Object 다형성의 한계**
- 다형성을 활용하기 위해 메서드 오버라이딩을 함께 사용해야한다.
- Object는 다형적 참조가 가능하지만 자식 인스턴스의 메서드는 가지고 있지 않다.
  - 메서드 오버라이딩이 불가능하며
  - 각 객체의 기능을 호출하려면 다운캐스팅이 필요하다.

### Object 배열
```java
public static void main(String[] args) {
    Dog dog = new Dog();
    Car car = new Car();
    Object obj = new Object();

    Object[] objects = {dog, car, obj};

    size(objects); // 3
}
```

### Object가 없다면?
- Object 배열과 같이 모든 객체를 받을 수 있는 메서드를 만들 수 없다.
- 공통의 약속 없이 같은 기능을 하는 수많은 클래스가 만들어질 가능성 ↑

---

## toString()
객체의 정보를 문자열 형태로 제공하며, 디버깅과 로깅에 유용하게 사용된다.

패키지를 포함한 객체의 이름과 객체의 참조값(해시코드)을 16진수로 제공

```java
public static void main(String[] args) {
    Object o = new Object();
    String string = o.toString();

    // toString() 반환값 출력
    System.out.println(string);

    // object 직접 출력
    System.out.println(o);
}
```
- 이때 toString()으로 출력한 것과 object를 직접 출력한 것의 값이 동일한데,
- System.out.println()는 내부에서 toString()을 호출한다.
```java
public void println(Object x) {
    String s = String.valueOf(x);
    //...
}

public static String valueOf(Object obj) {
    return (obj == null) ? "null" : obj.toString();
}
```

### toString() 오버라이딩
- 기본적으로 제공하는 클래스 정보와 참조값으로는 객체의 상태를 온전히 나타내지 못한다.
- 보통 toString()을 재정의해서 보다 유용한 정보를 제공하는 것이 일반적.
```java
public static void main(String[] args) {
    Dog dog = new Dog();
    
    // 재정의 x
    System.out.println(dog); // java.lang.Dog@5594a1b5
        
    // 재정의    
    System.out.println(dog); // Dog{dogName='멍멍이1', age=2}
}
```

- Object 하위 클래스가 Object 타입을 받는 인수로 전달되고 toString()을 호출했을 때
- 하위 클래스에 toString()이 재정의 되지않았다면 Object의 toString()을 사용하게 되고,
- 재정의 되었다면 그 메서드를 실행한다.
