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

모든 클래스는 Object 상속 받으므로 Object 클래스의 메서드 또한 사용 가능한데, 그 중 toString()은 객체의 정보를 제공한다.

### 자바에서 Object 클래스가 최상위 부모 클래스인 이유는 뭘까
- 공통 기능 제공
  - 프로그래밍이 단순화되고, 일관성을 가진다.
- 다형성의 기본 구현
  - Object는 모든 객체를 참조할 수 있다.
  - 모든 자바 객체는 Object 타입으로 처리될 수 있다.