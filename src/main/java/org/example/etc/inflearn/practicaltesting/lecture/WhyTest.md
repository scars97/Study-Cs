## 테스트는 왜 필요할까

---

테스트 코드 작성을 안해봐서 잘 모른다. 하지만 필요성은 느낀다.

현재 엄청난 레거시 환경의 서비스를 유지보수하고 있다.<br>
기능 장애가 발생했을 때, 나는 어떻게 대응하고 있을까?
- 실제 환경에서 장애가 발생한 기능에 에러 내가면서 테스트를 진행한다.
- 에러를 내고, 로그를 확인한다.
- 예외가 발생한 코드 위치를 찾아 코드를 분석하고 고친다.

굉장히 비효율적인 행동이라 생각한다.

강의에서 말하는 테스트 코드를 작성하지 않았을 때의 문제점이다.
1. **기능 장애에 대해 경험과 감에 의존하게 된다.**
2. 늦은 피드백
3. 유지보수 어려움
4. 소프트웨어 신뢰 하락

반대로 테스트 코드가 작성되어 있다면 어떨까.
1. 빠른 피드백
2. 자동화
3. 안정감

장애가 발생한 기능에 대해(테스트 코드가 잘 작성되어 있다면) 테스트 코드를 실행해보면 된다.
문제 원인도 빠르게 파악할 수 있고, 그로 인해 대응 시간도 빨라질 것이다. 무엇보다 개발자가 편해진다.

---

### 테스트는 귀찮다.
하지만 해야 한다.