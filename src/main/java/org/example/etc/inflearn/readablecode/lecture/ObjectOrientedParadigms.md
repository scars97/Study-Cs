## 객체 지향 패러다임

---

### 추상의 관점으로 바라보는 객체 지향
- 객체? 
  - 어떤 목적을 가지고 추상화된 데이터(필드)와 데이터를 조작, 가공하는 코드가 담긴 것
  - 객체는 책임과 역할을 가진다.
- 캡슐화 : 객체의 내부 데이터, 로직을 일부분만 보이고 나머지는 숨겨 외부로부터 보호한다.
  - 객체가 제공하는 데이터를 일부 로직에 추상화하여 외부 세계와 통신한다.
  - 외부 세계가 객체에 접근하려면 객체가 제공하는 추상화된 로직을 사용해야 한다.
- 다형성 : 상위레벨에 추상화된 특징을 토대로 하위 레벨의 구현체들이 여러 형태로 변경될 수 있는 것
- 관심사의 분리
  - 일련의 작업을 묶어 역할 부여
  - 높은 응집도, 낮은 결합도 : 비슷한 관심사를 가지는 작업을 모으되, 각 작업들끼리의 결합도는 느슨해야 한다.

### 객체 설계
- 객체로 추상화하기
  - 객체의 공개 메서드 선언부를 통해 외부 세계와 소통 
    - 각 메서드의 기능은 객체의 책임을 드러내는 창구
  - 객체의 책임이 나뉨에 따라 객체 간 협력 발생
- 객체 만들 때 주의점
  - 1개의 책임이 명확하게 정의되어야 한다.
    - 외부 세계와 어떤 소통을 하려고 하는지?
  - setter 사용 자제
    - 객체 외부에서 직접적으로 객체 내부 데이터를 변경할 수 있는 방법.
    - 만약 외부에서 가지고 있는 데이터로 데이터 변경 요청을 해야하는 경우
      - update~ 와 같이 의도를 드러내는 네이밍을 고려하자
  - getter 사용도 자제하자.
    - 의도 없이 객체의 데이터를 함부로 꺼내는 것은 무례한 행동!
    - 객체에 메시지를 보내자
  - 필드의 수는 적을수록 좋다.
    - 불필요한 데이터가 많을 수록 복잡도가 높아지고 대응할 변화가 많아진다.

>많은 글에서 getter, setter 사용을 자제하라고 한다. 왜일까?

자신의 데이터를 지키기 위해 캡슐화했는데, 
아무런 의도 없이 외부에서 맘대로 데이터를 변경하거나 꺼내는 방법을 제공하는 것은 모순이라 생각된다.

## SOLID

**1. SRP (단일 책임)**
- 하나의 클래스는 단 한 가지의 변경 이유(책임)만을 가져야 한다.
- 객체가 가진 공개 메서드, 필드, 상수 등은 해당 객체의 단일 책임에 의해서만 변경되는지 확인
  - 객체의 상태가 변경되어야 한다면 해당 객체가 책임질 수 있는지?
  - 객체의 상태는 외부에서 변경하는 것이 아니라 객체 자기 자신이 상태를 관리해야한다.
- 관심사의 분리
- 높은 응집도, 낮은 결합도

**2. OCP (개방-폐쇄)**
- 확장에는 열려 있고, 수정에는 닫혀 있어야 한다.
  - 기존 코드의 변경 없이, 시스템의  기능을 확장할 수 있어야 한다.
- 추상화와 다형성을 활용해서 OCP를 지킬 수 있다.

**3. LSP (리스코프 치환)**
- 상속 구조에서 부모 클래스의 인스턴스를 자식 클래스의 인스턴스로 치환할 수 있어야 한다.
  - 자식 클래스는 부모 클래스의 책임을 준수하며, 부모 클래스의 행동을 변경하지 않아야 한다.
- LSP를 위반하면, 상속 클래스를 사용할 때 오동작, 예상 밖의 예외가 발생하거나 이를 방지하기 위해 불필요한 타입 체크가 동반될 수 있다.

**4. ISP (인터페이스 분리)**
- 클라이언트는 자신이 사용하지 않는 인터페이스에 의존하면 안된다.
- ISP 위반 시, 불필요한 의존성으로 인해 결합도가 높아지고, 특정 기능의 변경이 여러 클래스에 영향을 줄 수 있다.

**5. DIP (의존성 역전)**
- 상위 수준의 모듈은 하위 수준의 모듈에 의존해서는 안 된다. 둘 모두 추상화에 의존해야 한다.
  - 추상화 수준이 높은 쪽이 추상화 수준이 낮은 쪽에 의존해서는 안 된다.
- 의존성 방향
  - 순방향 : 고수준 모듈이 저수준 모듈을 참조하는 것
  - 역방향 : 고수준, 저수준 모듈이 모두 추상화에 의존 하는 것
  - 저수준 모듈이 변경되어도, 고수준 모듈에는 영향이 가지 않는다.