## 추상과 구체

중요한 정보는 가려내어 남기고, 덜 중요한 정보는 생략하여 버린다.

상세한 내용이 담긴 구체적인 글을 중요한 정보를 담은 한 문장으로 추상화.
추상화된 문장을 통해 내용을 유추하거나 재현할 수 있어야 한다.

### 컴퓨터 과학과 추상
0과 1밖에 읽을 수 없는 컴퓨터는 어떻게 고수준의 작업을 할 수 있을까.

- 고수준 : 추상화 레벨이 높다
- 저수준 : 추상화 레벨이 낮다

기계어 -> 프로그래밍 언어
하드웨어 -> 운영체제 -> 애플리케이션
OSI 7 Layer

### 읽기 좋은 코드와 추상화의 관계?
- 적절한 추상화는 복잡한 데이터와 복잡한 로직을 단순화하여 이해하기 쉽도록 돕는다.

### 잘못된 추상화
- 추상화 과정에서 중요한 정보를 부각시키지 못했을 때.
- 해석자가 동일하게 공유하는 문맥이 없을 때.
  - 중요한 정보의 기준이 다를 수 있다.

### 추상화의 대표적 행위
- 이름 짓기(메서드명, 변수명 등등)

### 이름 짓기
이름을 짓는다는 행위는, 추상적 사고를 기반으로 한다.
- 표현하고자 하는 구체에서 중요한 핵심 개념만을 추출하여 잘 드러내는 표현
- 도메인의 문맥 안에서 이해되는 용어

### 메서드와 추상화
- 잘 쓰여진 코드라면, 한 메서드의 주제는 반드시 하나다.
  - 메서드 안에 여러 주제가 있다면, 더 큰 맥락 안에서 포괄적인 의미를 담는 메서드로 작성
  - 어떤 행위를 하기 위한 작업 순서를 나열

카페 프로세스
```java
void 카페() {
    Menu 메뉴();
    Order 주문(Menu);
    Payment 결제(Order);
    Manufacture 제작(Order);
    Provide 제공(Order);
}
```

### 메서드 선언부
- 메서드 추상화에 대한 실질적인 코드 -> 반환타입 메서드며 (파라미터) {구현부}
- 추상화된 구체를 유추할 수 있는 적절한 의미가 담긴 이름
  - 파라미터와 연결지어 더 풍부한 의미를 전달할 수 있다. 
    - ex) Payment payment = paymentOf(order);
- 적절한 타입의 반환값 돌려주기
  - 반환 타입에 대한 의미가 명확해야 한다.
- void 대신 반환할 만한 값이 있는지 고민해보기
  - 반환값이 있다면 테스트도 용이해진다.

### 추상화 레벨
- 어떤 작업을 하는 코드를 메서드로 추출했을 때 또는 그 반대인 경우, 어떠한 경계가 생긴다.
  - 메서드가 사용되는 외부 세계와 전달하는 파라미터를 통해 메서드의 결과값을 주는 내부 세계
  - 객체가 사용되는 외부 세계와 해당 객체의 행위들이 담겨있는 내부 세계
  - api가 사용되는 외부 세계와 api가 구현되어있는 내부 세계

**하나의 세계 안에서는 추상화 레벨이 동등해야 한다.**
- 택배 예약 기능 구현 사례
  - 외부와 통신하는 api를 2개 사용하고 있었음
    - 주소데이터를 받아오는 api
    - 결제 api
  - 주소 api는 협력사에서 준 jar 파일로 소켓통신
  - 결제 api는 http 통신
- 둘 다 외부와 통신하는 기능을 가지고 있지만 통신 방식이 달라 읽기 쉽지 않았음.