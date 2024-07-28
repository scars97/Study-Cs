# Spring

---

### Servlet
- Http 요청을 처리하고 동적 웹 페이지를 생성
- 웹 요청을 Servlet으로 처리하게 된다면 개발자는 비즈니스 로직에 집중할 수 있다.
- 클라이언트의 요청에 맞는 서비스를 처리하고 응답

### Servlet은 어떻게 관리되나요?
- 사용자 요청이 들어오면 Servlet Container는 해당 요청에 맞는 servlet을 찾는다.
- 찾고자 하는 Servlet 인스턴스가 존재한다면 그대로 사용하고, 없다면 새로운 Servlet을 생성한다.
- Servlet Container에 스레드를 생성하고 HttpServletRequest, HttpServletResponse를 인자로 service 실행
- 요청이 처리되면 생성된 Request, Response 객체는 소멸된다.
- 여기서 작업이 끝난 서블릿 자체는 소멸되지 않는데 그 이유는 싱글톤으로 관리되기 때문이다.
- Servlet Container는 Servlet의 생명주기를 관리한다.

### Front Controller Pattern
- 각 서블릿의 중복된 로직을 하나의 서블릿에서 처리할 수 있게 하는 패턴
- 클라이언트의 요청을 앞단에서 전담하는 매니저 역할
- Spring Mvc에서는 이것을 Dispatcher Servlet이라 한다.

### Dispatcher Servlet

### Spring 이란? (EJB-J2EE 비교 설명)
- 좋은 객체 지향 애플리케이션을 개발할 수 있게 도와주는 프레임워크

### IOC, DI ?
- IoC : 제어의 역전
  - 의존 객체를 직접 생성하는 것이 아니라 생성자 등을 통해 외부에서 주입받아 사용하는 것
  - 클래스 간 결합을 느슨히 하기 위함
    - 한 클래스의 변경에 따른 다른 클래스들의 영향을 최소화
  - Ioc는 제어권이 내부에서 외부로 역전된 것
    - 스스로를 제어할 수 없다..!
  - 원칙
- DI : 의존성 주입
  - IoC를 구현하기 위한 하나의 방법 -> 디자인 패턴
  - 클래스 간에 의존 관계가 있다는 것은?
    - 한 클래스가 바뀔 때 다른 클래스가 영향을 받는 것
  - 외부에서 객체를 주입해준다는 구체적인 행위.
    - DI를 통해 IoC가 이루어질 수 있다.
  - @Autowired 
    - 필드 주입
      - 필드 주입은 기존에 불가능한 주입을 프레임워크의 힘을 빌려 주입한다.
      - 테스트 시 수동으로 의존성을 주입하고 싶어도 생성자, setter도 없으므로 의존성을 부여할 수 없다.
      - 필드 주입은 의존성이 프레임워크에 강하게 종속된다는 문제가 있다.
    - setter 주입
      - setter 메서드를 생성하기 위해 빈 생성자 또는 빈 정적 팩토리 메서드가 필요하다.
      - 파이널 필드를 만들 수 없고, 의존성의 불변을 보장할 수 없다.
      - 의존성을 동적으로, 선택적으로 주입할 때 사용
    - 생성자 주입
      - 객체 생성 시점에 의존성 주입
      - 순환참조 문제 방지
- DI를 자동으로 해주고 프로그램의 제어권을 가져가는 역할을 해주는 것이 스프링

### Spring Ioc Container 란?
- 애플리케이션 컴포넌트의 중앙 저장소
- Spring Ioc Container가 생성되면 빈 스코프가 싱글톤인 객체를 생성
- 빈 설정 소스로부터 빈 정보를 읽어들이고, 빈을 구성하고 제공한다. -> Bean Life-cycle 관리
- 왜 빈을 관리하나?
  - 의존성 자동 주입으로 해당 의존성을 사용하는 로직에만 집중할 수 있다.
  - 의존성이 주입될 객체가 항상 동일함을 보장하기 위함

### Bean?
- Spring Ioc Container가 관리하고 있는 객체
- DI를 받고 싶다면 객체는 빈으로 등록되어야 한다.
- Spring Ioc Container에 등록되는 Bean들은 싱글톤 객체로 만들어진다.
- Bean이 필요한 이유
  - Spring Ioc Container가 특정 객체의 라이프사이클을 관리한다는 것을 명시

### Bean Scope의 종류
- 싱글톤
  - Spring Ioc Container 와 생성되고 소멸
  - 싱글톤으로 등록된 빈은 상태를 가지면 안된다.
- 프로토타입 : 매번 다른 객체
  - Spring Ioc Container 와 생성되고 소멸되는 것이 아닌 요청이 올 때마다 객체가 생성된다.
  - 상태를 가질 수 있다.

### Spring Bean Life-cycle 에 대해서 설명해주세요.
- 객체 생성 + property 설정
  - Spring Ioc Container가 생성되면 빈 스코프가 싱글톤인 객체를 생성
  - 설정 관련 메타데이터들을 이용해 통일된 Bean Definition을 생성
  - 빈으로 등록할 POJO와 Bean Definition 정보를 이용해 Bean을 생성
  - 싱글톤으로 등록된 빈의 이름을 key, 객체를 value로 저장
- 의존 설정
- 초기화 - 사용 - 소멸

### Configuration은 어떻게 Bean을 등록하고 관리할까요?

### @Bean 과 @Component 는 각각 언제 사용되고, 어떤 차이점을 가지나요?

### 순환 참조는 무엇이고 어떤 상황에서 발생할까요?
- 

### Field Injection을 사용하면 안되는 이유?

### (Field 주입과 대비하여) 생성자 주입은 빈 생성 때 사용되는 리플랙션 외에 추가적인 리플랙션을 진행하나요?

### Spring, Spring Boot 차이점

### Interceptor와 Filter의 차이점
- 스프링에서는 어떻게 구현할 수 있는지

### Message Converter는 어느 시점에 사용되고 어떤 기능을 제공하나요?

### Value Object, Data Transfer Object, Data Access Object 대해서 각각 설명해 주세요.

### Spring Aop

### Dynamic Proxy

### @Transactional를 스프링 Bean 메서드 A에 적용하였고, 해당 Bean의 메서드 B가 호출되었을 때 메서드 내부에서 메서드 A를 호출하면 어떤 요청 흐름이 발생하게 되나요?

### MVC 1, 2 개념에 대해서 설명해 주세요.

### MVC 동작 방식

### Spring MVC에서 HTTP 요청이 들어왔을 때의 흐름을 설명해 주세요.
