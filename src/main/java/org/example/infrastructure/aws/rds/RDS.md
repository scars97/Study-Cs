## RDS

---

### RDS?
- 여러 관계형 DB 서비스를 AWS로부터 빌려서 사용하는 형태

### RDS를 왜 사용하는 걸까?
- 서버를 배포했을 때, 서버가 로컬 환경에 설치된 DB와 연결할 수 없다.
- DB도 외부 인터넷에서 접근할 수 있게 같이 배포해주어야 한다.
- 이러한 이유로 AWS RDS라는 DB를 빌려서 사용한다.

### EC2에 DB 설치
- RDS를 사용하지 안고 EC2에 DB를 직접 설치해 사용하기도 한다.
- 별도의 RDS 비용이 나오지 않기 때문에 비용을 절감할 수 있다.
- 하지만 현업에서는 위 방법을 사용하지 않는다.
  - EC2 서버 장애 발생 시 포함되어 있는 DB도 같이 장애가 발생한다.