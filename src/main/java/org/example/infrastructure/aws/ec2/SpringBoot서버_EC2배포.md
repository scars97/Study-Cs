## 1. Ubuntu 환경에서 JDK 설치
```
$ sudo apt update && /
sudo apt install openjdk-17-jdk -y
```

## 2. 프로젝트 clone
```
git clone '프로젝트 주소'
```

## 3. application.yml 직접 만들기
- 민감한 정보가 포함된 파일은 git으로 버전 관리를 하지 않는 것이 일반적
- application.yml 과 같은 파일은 별도로 EC2 인스턴스에 올려주어야 한다.
```
server:
    port: 80
    
spring:
    ...:
    ...:
```

### 4. 서버 실행
```
$ ./gradlew clean build
$ cd ~/프로젝트 디렉토리명/build/libs
$ sudo java -jar 디렉토리명-0.0.1-SNAPSHOT.jar
```
- 백그라운드에서 Spring Boot 실행
```
$ sudo nohup java -jar 디렉토리명-0.0.1-SNAPSHOT.jar
```

### 5. 동작 확인
- 할당받은 탄력적 IP를 브라우저 주소창에 입력.

---

### 서버 종료
터미널에서 'control + c' 로 종료.

### 비용 나가지 않게 EC2 종료 방법
- EC2 인스턴스 -> 인스턴스 상태 -> 인스턴스 종료.
- 네트워크 및 보안 -> 탄력적 IP -> 작업 -> 탄력적 IP 주소 릴리스