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
## Object와 OCP
**OCP - 개방 폐쇄 원칙**

확장에는 열려있어야 하고, 수정에 대해서는 닫혀 있어야 한다.

Object 클래스가 없고, toString()과 같은 공통의 메서드가 없다면,

각 객체는 객체 타입에 맞는(구체화), 동일한 기능을 하는 메서드를 여럿 만들 것이다.

새로운 객체가 추가될 때마다 객체 타입에 맞는 기능을 추가해줘야 하며, 코드는 더욱 지저분해질 것.

Object를 사용함으로써, 다형적 참조를 활용함으로써 모든 객체 인스턴스를 받을 수 있게 되고(추상화)

공통으로 사용되는 toString() 메서드를 재정의하여 기능을 확장할 수 있다.

---
※ Object 에서 final이 아닌 메서드는 모두 재정의를 염두에 두고 설계된 것이라 재정의 시 지켜야 하는 일반 규약이 정의되어 있다.

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

- 기본적으로 제공하는 클래스 정보와 참조값으로는 객체의 상태를 온전히 나타내지 못한다.
- 보통 toString()을 재정의해서, 보다 유용한 정보를 제공하는 것이 일반적.
```java
public static void main(String[] args) {
    Dog dog = new Dog();
    
    // 재정의 x
    System.out.println(dog); // java.lang.Dog@5594a1b5
        
    // 재정의 o
    System.out.println(dog); // Dog{dogName='멍멍이1', age=2}
}
```
- Object 하위 클래스가 Object 타입을 받는 인수로 전달되고 toString()을 호출했을 때
- 하위 클래스에 toString()이 재정의 되지않았다면 Object의 toString()을 사용하게 되고,
- 재정의 되었다면 그 메서드를 실행한다.
- toString()은 재정의하는 것이 좋다.
- apache commons:commons-lang 라이브러리 설명 (리플렉션 기반) [참고링크](http://www.java2s.com/example/java-api/org/apache/commons/lang3/builder/tostringstyle/json_style-0.html)
```
toString 일반 규약
- 간결하면서 사람이 읽기 쉬운 형태의 유익한 정보를 반환해야 한다.
```

## equals()

### 1.동일성과 동등성
동등성 비교를 위한 equals()를 제공한다.

**동일성(Identity)** : == 연산자를 사용해 두 객체의 참조가 동일한 객체를 가리키고 있는지 확인.<br>
**동등성(Equality)** : equals()를 사용하여 두 객체가 논리적으로 동등한지 확인.

Object가 제공하는 equals()는 기본적으로 == 으로 동일성 비교를 제공한다.
```java
public static void main(String[] args) {
    UserV1 user1 = new UserV1("id-100");
    UserV1 user2 = new UserV1("id-100");

    System.out.println("identity = " + (user1 == user2)); // false
    System.out.println("equality = " + (user1.equals(user2))); // false
}
```

동일성 비교를 원한다면 equals()를 재정의해야 한다.

### 2. 구현
```java
public class UserV2 {

    private String id;

    public UserV2(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        UserV2 user = (UserV2) o;
        return id.equals(user.id);
    }
}

public class Example {
    public static void main(String[] args) {
        UserV2 user1 = new UserV2("id-100");
        UserV2 user2 = new UserV2("id-100");

        System.out.println("identity = " + (user1 == user2)); //false
        System.out.println("equality = " + user1.equals(user2)); // true
    }
}
```

#### 정확한 equals()?
아래의 규칙을 지켜야 한다.

- 반사성(Reflexivity) 
  - 객체는 자기 자신과 동등해야 한다. ( x.equals(x) 는 항상 true ).
- 대칭성(Symmetry)
  - 두 객체가 서로에 대해 동일하다고 판단하면, 이는 양방향으로 동일해야 한다.
  ( x.equals(y) 가 true 이면 y.equals(x) 도 true ).
- 추이성(Transitivity)
  - 만약 한 객체가 두 번째 객체와 동일하고, 두 번째 객체가 세 번째 객체와 동일하다면, 첫
  번째 객체는 세 번째 객체와도 동일해야 한다.
- 일관성(Consistency)
  - 두 객체의 상태가 변경되지 않는 한, equals() 메소드는 항상 동일한 값을 반환해야
  한다.
- null에 대한 비교
  - 모든 객체는 null 과 비교했을 때 false 를 반환해야 한다

만약 다음 상황 중 하나에 해당한다면 재정의하지 않는 것이 좋다.
- 각 인스턴스가 본질적으로 고유하다.
- 인스턴스의 논리적 동치성(logical equality)을 검사할 일이 없다.
- 상위 클래스에서 재정의한 equals가 하위 클래스에도 들어맞는다.
  - List 구현체들은 AbstractList로부터 equals를 상속받는다.
- 클래스가 private이거나 package-private이고 equals 메서드를 호출할 일이 없다.