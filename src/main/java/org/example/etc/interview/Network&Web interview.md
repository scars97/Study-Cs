# Network & Web

---

### 프로토콜 계층
- 애플리케이션 계층 : HTTP, FTP
- 전송 계층 : TCP, UDP
  - TCP - 송수신 port, 전송제어, 순서, 검증 정보 등의 데이터를 포함해 IP에서 해결하지 못했던 문제를 해결한다.
- 인터넷 계층 : IP
  - 데이터 송신 주체와 수신 주체 정보를 담는다.
  - IP 패킷을 전송한다고 표현하는데, 패키지 + 버킷의 합성어로 물품을 택배 상자 안에 넣어서 보내는 것과 비슷한 개념
- 네트워크 인터페이스 계층 : LAN 장비
- 동작 방식
  - 프로그램에서의 메시지 요청 발생 (HTTP, FTP 통신)
  - Socket 라이브러리를 통해 OS 계층(TCP) 전달 -> TCP 정보를 생성하고 요청 메시지 데이터에 포함
  - TCP 정보가 포함된 메시지에 IP 정보를 포함시키고 패킷(패키지 + 버킷) 생성
  - 네트워크 인터페이스 계층의 LAN 카드를 통해 전송될 때, 이더넷 프레임이 씌워져 전송된다.

### IP
- 인터넷 통신을 위한 규약
- 지정한 IP 주소에 데이터 전달
- 패킷이라는 통신 단위로 데이터 전달
  - 헤더 : 데이터 송신의 출발점과 도착점 같은 제어 정보를 포함
    - 출발지 주소, 목적지 주소, 버전, TTL
  - 페이로드 : 전송할 실제 데이터를 포함
- 라우팅 : IP 패킷이 출발지에서 목적지로 전송될 때 최적의 경로를 결정하는 과정
  - 라우터라는 네트워크 장치를 통해 네트워크 간의 트래픽을 안내하고 올바른 경로로 패킷을 전달한다.
- 비연결성 : 패킷을 받을 대상이 없거나 서비스 불능 상태여도 패킷 전송
  - 대상 서버가 통신이 가능한 상태인지를 알 수 없다.
- 비신뢰성
- 프로그램 구분 : 같은 IP를 사용하는 서버에서 통신하는 애플리케이션이 둘 이상이라면 구분이 불가능
- IP 주소란 네트워크에 연결된 장치를 식별하는 고유한 숫자 주소.
  - IPv4 : 32비트 주소 체계를 사용. 최대 43억 개의 주소를 제공. 4개의 10진수(0~255)로 구성되어 있다. ex) 192.168.0.1
  - IPv6 : 128비트 주소 체계로 사실상 무제한의 주소를 제공. 8개의 16진수 블록으로 구성되어 있으며, 각 블록은 콜론으로 구분된다. ex) 2001:0db8:85a3:0000:0000:8a2e:0370:7334

### TCP와 UDP의 차이는 무엇인가요?
- TCP(전송 제어 프로토콜) : 신뢰성 있는 데이터 전송을 보장하기 위해 설계된 프로토콜
  - 연결 지향(3/4-way-handshake), 데이터 전달 보증(서버는 요청을 받고, 요청에 대한 확인 응답을 보낸다.), 순서 보장
- UDP(사용자 데이터그램 프로토콜) : IP와 비슷한 기능을 가지지만 port(같은 IP 내에서 프로세스를 구분), checksum(메시지에 대한 검증) 추가
  - 데이터를 보내기만 하고, 수신 여부는 확인하지 않는다. 전송 속도는 빠르지만 신뢰성이 떨어진다.
  - UDP를 통해 DNS 요청이 이루어진다.

### DNS
- 전화번호부의 역할, 도메인명을 IP 주소로 변환
- IP는 변경될 수 있는데 변경된다면 클라이언트는 변경된 IP에 접근하지 못하는 경우가 있다.
- DNS 서버를 두고 DNS 서버는 IP에 대한 도메인명을 가진다.
- 클라이언트는 DNS 서버에 도메인명을 요청하고 서버는 해당 도메인명을 가진 IP를 반환한다.
  
### 어느 서비스에서 UDP 기반의 프로토콜을 사용하는 것이 좋을까요?
- 빠른 데이터 전송, 데이터의 일부 손실이 허용될 수 있는 서비스에 적합하다.
- 인터넷 전화 서비스(zoom) : 음성 통화는 실시간으로 이루어져야 하며, 약간의 음성 데이터 손실은 인지하지 못한다.
  - TCP의 과도한 재전송은 음성 지연을 유발할 수 있다.
- DNS : DNS 요청은 짧고 간단하며, 빠르게 응답 받아야 한다. 패킷이 손실되어도 클라이언트가 요청을 다시 보내면 되므로 UDP가 효율적
- DHCP : IP 주소를 동적으로 할당하는 서비스

### 3 Way Handshake와 4 Way Handshake는 무엇인가요?
- 3-way-handshake
  - TCP/IP 프로토콜을 이용해서 통신을 하는 응용 프로그램이 데이터를 전송하기 전에,
  - 정확한 전송을 보장하기 위해 상대방의 컴퓨터와 사전에 세션을 수립하는 과정.
  - SYN : 클라이언트가 서버에게 연결을 요청하는 메시지를 보낸다. 이 메시지에는 초기 시퀀스 번호가 포함된다.
  - SYN-ACK : 서버는 요청을 수신하고, 시퀀스 번호를 확인한 후, 자신의 시퀀스 번호를 포함한 확인 응답을 클라이언트에게 전송
  - ACK : 클라이언트는 서버의 응답을 받고, 연결 설정이 완료되었음을 알리는 응답을 서버에게 보낸다.
- 4-way-handshake
  - 3-way-handshake는 TCP의 연결을 초기화 할 때 사용한다면, 4-way-handshake는 `세션을 종료하기 위해 수행되는 절차`다.
    - 클라이언트가 연결을 종료하겠다는 FIN 플래그를 전송 (FIN-WAIT 상태)
    - 서버는 FIN 플래그를 받고, 확인 메시지인 ACK를 보낸다. (CLOSE-WAIT 상태)
    - 연결을 종료할 준비가 되면, 연결 해지를 위한 준비가 완료되었음을 알리기 위해 서버는 FIN 플래그 전송 (LAST-ACK 상태)
    - 클라이언트는 해지 준비되었다는 ACK를 보낸다.
    - 서버는 클라이언트에서 보내는 ACK를 확인하면 연결을 종료한다.
- 논리적 연결 검증

### 3 Way Handshake는 왜 3번 요청을 주고 받는 것인가요?
- 두 당사자가 서로의 시퀀스 번호를 동기화하고 연결되었음을 확인하기 위해 최고한 3번의 통신이 필요하기 때문이다.
- 클라이언트의 요청, 요청에 대한 서버의 수락, 클라이언트가 서버의 수락을 확인하고 최종적으로 연결을 확인한다.

### 웹 브라우저 요청 흐름
- 요청 받은 url의 도메인명을 DNS에서 해당 IP 조회
- 웹 브라우저는 HTTP 요청 메시지 생성
- Socket 라이브러리를 통해 전달
  - TCP/IP 연결 handshake -> 데이터 전달
- 데이터를 감싼 TCP/IP 패킷 생성 + HTTP 메시지 포함
- 목적지 IP에 데이터 전달
- 목적지 IP에서는 전달된 HTTP 메시지 해석하여 데이터 조회 후, HTTP 응답 메시지 생성
- 브라우저는 응답 받은 HTTP 메시지 데이터를 랜더링

### HTTP는 무엇인가요?
- 웹에서 데이터를 주고 받기 위한 프로토콜
- 클라이언트 서버 구조 : 클라이언트는 서버에 요청을 보내고, 응답을 대기 -> 서버가 요청에 대한 결과를 만들어서 응답
- 무상태 프로토콜(Stateless) : 서버가 클라이언트의 상태를 유지 X
  - 무상태는 클라이언트 요청이 증가해도 서버를 대거 투입할 수 있다 -> 무상태는 응답 서버를 쉽게 바꿀 수 있다.
  - 로그인과 같은 상태 유지가 필요하다면 브라우저 쿠키와 서버 세션등을 사용해서 상태 유지
  - 무상태성을 채택한 이유 : 단순성, 확장성, 서버 자원의 효율적 사용 등
- 비 연결성(Connectionless) : HTTP는 기본적으로 연결을 유지하지 않는다. -> 서버 자원을 효율적으로 사용하기 위함
  - 연결을 유지하는 경우 클라이언트의 요청이 없어도 연결을 유지하기 때문에 서버 자원 낭비.
  - 비연결성은 요청에 대한 응답을 주고 연결을 끊는다. 클라이언트의 요청이 있을 때 다시 연결한다.
  - 연결을 맺고 끊을 때마다 handshake 과정으로 인해 속도가 지연될 수 있다.
  - 자원이 필요할 때마다 연결을 맺고 끊음이 반복되는데, HTTP는 지속 연결(Persistent Connections)로 문제 해결

### HTTP 멱등성에 대해 설명해주세요.
- 멱등 : 같은 요청에 대한 응답 결과는 같아야 한다.
  - POST의 경우 멱등하지 않는데, POST는 리소스를 생성하는데 사용되며, 동일한 POST 요청을 여러 번 보내면 리소스가 중복 생성될 수 있다.
  - 멱등은 외부 요인으로 중간에 리소스가 변경되는 것까지는 고려하지 않는다.
- 만약 서버가 정상 응답을 주지 못했을 때, 클라이언트는 같은 요청을 재시도한다. 요청이 멱등성을 가진다면 동일한 요청이 여러 번 전송되더라도 서버 상태나 결과에 문제가 생기지 않는다.

### HTTP의 버전별 차이를 알려주세요. (0.9 1.0 1.1 2.0)
- 0.9 : GET 메서드만 지원, HTTP 헤더X
- 1.0 : 메서드, 헤더 추가
- **1.1** : 지속연결, 케시 메커니즘 개선(Cache-Control)
- 2 : 성능 개선
- 3 : TCP 대신 UDP 사용, 성능 개선

### HTTPS는 무엇인가요?
- HTTP의 보안 버전으로, 데이터를 안전하게 전송하기 위해 설계된 프로토콜
  - HTTP 위에 SSL, TLS 프로토콜을 추가하여 데이터 전송을 암호화
  - 데이터가 중간에 가로채어지거나 변조되는 것을 방지할 수 있다.
- SSL : 클라이언트와 서버 사이에 전송되는 데이터를 암호화하여 인터넷 연결을 보호하기 위한 표준 기술
- TLS : SSL의 향상된 버전
- 연결 과정
  - 클라이언트가 HTTPS 요청을 보내면 SSL/TLS 핸드셰이크 시작
  - 서버는 SSL/TLS 인증서를 제공. 인증서에는 서버의 **공개키**과 서버의 신원이 포함된다.
    - 공개키는 초기 단계에서 대칭키를 안전하게 전달하기 위해 사용
  - 클라이언트는 인증서가 유효한지 검증. 유효하다면 서버의 공개키를 사용해 **대칭키**를 암호화하여 서버에 요청
    - 대칭키는 모든 통신 데이터를 암호화하는 데 사용
  - 서버는 개인키로 클라이언트의 대칭키를 복호화. 대칭키는 이후의 통신에 사용되며 클라이언트와 서버 간의 모든 데이터는 대칭키를 사용해 암호화된다.

### 웹소켓과 소켓 통신 차이
- 소켓 통신
  - 소켓은 통신을 위한 인터페이스로, 네트워크 상에서 IP 주소와 포트 번호를 사용하여 양쪽에서 데이터를 송수신할 수 있는 엔드포인트를 의미
    - 엔드포인트의 정보를 포함하고 있으므로 하나의 연결에 대한 하나의 소켓이 존재
    - 하나의 프로세스는 동시에 여러 소켓을 가질 수 있다.
  - 전송 계층의 TCP/UDP 프로토콜에서 사용
    - 시스템 프로그래밍에서 사용되며, 클라이언트 서버 모델을 구현할 때 사용
    - 웹 브라우저와 직접 통합되지 않으며, 네트워크 프로그래밍에서 사용된다.
- 웹소켓
  - 애플리케이션 계층의 TCP 기반 프로토콜
  - HTTP와 함께 사용되어 웹 환경에서 실시간으로 양방향 통신을 가능하게 한다.
    - HTTP는 데이터 전송 완료 후 TCP 연결을 해제하고, 웹소켓은 연결을 유지한다.
    - 초기 연결 설정에는 HTTP를 사용하지만, 이후에는 독립적인 통신 채널로 전환된다.
  - 클라이언트가 HTTP 요청을 보내면 웹소켓 연결을 시작하고, 서버가 요청을 수락하면, HTTP 연결이 웹소켓 연결로 업그레이드된다.
  - 주로 실시간 웹 환경의 애플리케이션에서 사용된다. -> 채팅, 주식, 게임

### Keep Alive는 무엇일까요?
- Connection을 유지하기 위한 메커니즘
- TCP Keep Alive
  - 네트워크 수준에서 연결이 유효한지 확인하는 기능.
  - 오랜 시간 동안 연결 상태일 때 연결이 끊어졌는지 감지하기 위해 사용된다.
  - TCP Keep Alive는 기본적으로 비활성화되어 있으며, 활성화할 경우 주기와 재시도 횟수를 설정할 수 있다.
- HTTP Keep Alive
  - 애플리케이션 수준에서 단일 TCP 연결을 재사용하여 여러 HTTP 요청/응답을 처리할 수 있다.
    - 하나의 TCP Connection에서 진행되기 때문에 TCP 연결을 위한 handshake는 한번만 동작한다.
  - HTTP1.1에서는 keep-Alive가 기본적으로 활성화되어 있다.
  - 서버는 keep-Alive의 타임아웃이나 최대 요청 수를 설정할 수 있다. 설정된 조건이 만족되면 연결이 자동으로 종료된다.

### Polling, Long Polling, Pulling 기법은 각각 무엇이고 어떠한 Trade Off를 가지고 있나요?

### 구현된 HTTP API는 어떠한 요소들을 만족해야 RESTful한 API 라고 부를 수 있나요?
- HTTP API
  - HTTP 프로토콜을 사용하는 모든 API를 의미
  - GET, POST, PUT, DELETE 등의 HTTP 메서드를 사용
  - 특정 아키텍처 스타일에 의존하지 않으며 SOAP, GraphQL, gRPC 등 다양한 프로토콜이나 패턴과 함께 사용될 수 있다.
- REST API
  - REST 아키텍처 스타일을 따르는 API
  - 무상태성 : 모든 요청은 독립적이며, 서버는 클라이언트의 상태를 기억하지 않는다. 각 요청은 필요한 모든 정보를 포함해야 한다.
  - Resource-Based : REST API는 리소스에 초점을 맞추며, 각 리소스는 URI로 식별된다.
  - HATEOAS : 응답 메시지에 관련 링크를 포함하여 클라이언트가 리소스 상태에 따라 동적으로 다음 행동을 결정할 수 있게 한다.
    - REST의 완전한 구현에서 HATEOAS가 요구된다.
  - 계층화 시스템 : 로드 밸런서, 프록시, 게이트웨이 등의 중간 서버를 두고 클라이언트와 통신할 수 있다.
    - 보안, 확장성, 관리 측면에서 이점을 제공한다.
- 클라이언트 서버 구조, 무상태성, 캐시 가능성, 인터페이스 일관성 등이 지켜져야 Restful한 API라 부를 수 있다.

### Cookie와 Session 방식은 어떠한 차이점을 가지나요?
- Cookie
  - 서버가 사용자의 웹 브라우저에 전송하는 작은 데이터 조각
    - 사이트 방문 이력, 검색 기록, 로그인 상태
  - 브라우저는 이를 저장하고 동일한 서버에 재요청시 데이터를 함께 전송한다.
  - HTTP는 상태를 유지하지 않기 때문에 웹사이트의 재방문의 경우 효율이 떨어질 수 있다. 이를 보완하기 위해 위해 쿠키가 사용된다.
  - 브라우저에서 관리되기 때문에 클라이언트가 직접 값을 수정할 수 있다.
    - 쿠키 안에 중요 데이터가 포함된다면 수정이 가능하기 때문에 보안에 취약하다
- Session
  - 웹 사이트에 이용되는 사용자 정보를 서버에 저장하는 방법 -> 인증에 대한 정보를 서버가 저장
  - 중요한 정보는 서버에 저장하고, 그에 해당하는 고유한 sessionId를 생성하여 쿠키로 전달한다.
    - 쿠키에 sessionId 외의 정보를 기록하지 않음으로써 안정성이 확보된다.
  - 정보가 서버에 있기 때문에 처리 속도에 대한 비용이 발생한다.
  - 서버 자원을 사용하기 때문에 데이터가 많아진다면 저장 공간에 대한 비용이 발생한다.

### 토큰
- 인증을 위한 문자열로, 클라이언트가 서버에 요청할 때마다 인증 토큰을 포함하여 사용자를 인증한다.
- 토큰은 상태를 유지하지 않고, 클라이언트가 요청마다 인증 정보를 포함시켜 서버에 전달하는 방식이다.

### 웹서버와 WAS 차이
- 웹 서버
  - 클라이언트가 웹 브라우저를 통해 요청한 `정적 콘텐츠를 제공`하는 역할
  - 웹 서버는 주로 HTTP 프로토콜을 사용하여 작동하며, 클라이언트가 URL을 통해 요청한 웹 페이지를 찾아 전송.
  - Apache, Nginx
- WAS
  - 웹 애플리케이션을 실행하여 동적 콘텐츠를 생성하고, `웹 서버와 클라이언트 간의 데이터 처리를 담당하는 역할`
  - 클라이언트의 요청에 따라 DB에서 정보를 가져오거나, 웹 애플리케이션을 실행하여 동적인 웹 페이지를 생성한 후 결과를 웹 서버에 전달. 웹 서버는 이를 받아 클라이언트에게 전달
  - 인터넷상에서 HTTP를 통해 사용자 컴퓨터나 장치에 애플리케이션을 수행해주는 미들웨어
  - tomcat, 웹스피어

### CGI(Common Gateway Interface)
- 웹 서버상에서 프로그램을 동작시키기 위한 방법을 정의한 프로그램
- 초기의 동적인 웹 페이지 생성 방식 중 하나로, 웹 서버가 정적인 HTML 파일을 제공하는 대신, 외부 프로그램을 호출하여 동적으로 HTML 콘텐츠를 생성한다.
- 동작방식
  - 클라이언트 요청 : 브라우저를 통해 URL을 요청
  - GGI 프로그램 실행 : 요청된 CGI 프고그램을 운영 체제의 프로세스로 실행.
    - 이때 웹서버는 HTTP 요청에 포함된 데이터를 CGI 프로그램에 전달
  - 결과반환 : CGI 프로그램이 결과를 생성하면, 웹서버에 반환. 반환된 결과에는 HTTP 헤더와 본문 데이터(실제 응답 데이터)가 포함된다.
- 웹 개발의 초창기 기술로, 여러가지 단점이 존재
  - 성능 문제 : 요청마다 새로운 프로세스를 생성해야 한다.
  - 확장성 문제: CGI 방식은 동시 사용자 수가 증가할수록 서버의 부하가 증가한다. 대규모 웹 애플리케이션에는 적합하지 않다.
  - 보안 문제 : HTTP 요청을 처리하기 때문에, 보안 취약점(SQL 인젝션, XSS)에 노출될 수 있다.

### Servlet Spec은 무엇이고 CGI와 어떠한 차이점을 가지고 있나요?
- Java 플랫폼을 위한 서버 측 웹 애플리케이션 개발 표준을 정의하는 사양.
- 웹서버와 클라이언트 간의 요청과 응답을 처리
- 서블릿 컨테이너가 서블릿을 어떻게 로드하고 초기화하며, 요청과 응답을 어떻게 처리하고 전송하는 지 규정한다.
  - 서블릿 생명주기: init, service, destroy
  - HTTP 요청 응답 처리 : HTTP 메서드를 처리하는 doGet, doPost, doPut, doDelete 메서들를 제공
  - 애플리케이션 범위의 설정과 데이터를 공유할 수 있는 ServletContext 객체 제공
  - 세션관리
  - 필터
- CGI vs Servlet
  - 둘 다 웹 서버와 클라이언트 간의 요청-응답 처리를 위해 사용된다.
  - CGI 스크립트는 단순하지만, 대규모 애플리케이션을 개발하거나 유지보수하는 데 어려움이 있다. 코드를 재사용하거나 모듈화하는 데 한계가 있다.
  - 서블릿은 Java의 객체 지향 프로그래밍(OOP)을 사용하여 모듈화, 재사용, 유지보수하기 쉬운 코드를 작성할 수 있다. 또한, 여러 서블릿을 조합하여 대규모 애플리케이션을 개발할 수 있다. 

### JSON은 무엇인가요?
- js 객체 문법으로 구조화된 데이터를 표현하기 위한 문자 기반의 표준 포맷
- 일반적으로 서버에서 클라이언트로 데이터를 보낼 때 사용하는 양식
- 비동기 브라우저/서버 통신을 위해 XML을 대체하는 데이터 포맷
- JSON 사용
  - JSON.stringify(arg) : 객체를 문자열로 변환
  - JSON.parse(arg) : 문자열을 객체로 변환 -> 변환할 문자열은 반드시 JSON 형식이어야 한다.
```js
var json = {"test" : "value"}
var incodingData = JSON.stringify(json);

var str = '{"test" : "value"}';
var parsingData = JSON.parse(str);
```

### JWT란 무엇인가요? 왜 사용하게 되는 것인가요?
- JSON 객체로 모바일이나 웹의 사용자 인증을 위해 사용하는 암호화된 토큰
- 구성
  - 헤더: 토큰 타입, 서명을 해시하기 위해 사용된 알고리즘 지정
  - 페이로드: 클레임이라는 데이터 조각을 담고 있는 JSON 객체. -> 실제 정보
  - 시그니처: JWT의 무결성을 보장. 헤더와 페이로드를 인코딩한 후, 헤더에 지정된 알고리즘과 비밀 키(서버에서 설정한 secret-key)를 사용하여 생성된다.
    - JWT를 위변조로부터 보호한다.
- JWT는 필요한 모든 정보를 자체적을 포함하므로, 세션처럼 별도의 상태 저장소가 필요하지 않다. -> 무상태 서버 구조
- 표준화된 형식을 사용하므로, 여러 언어와 플랫폼에서 쉽게 사용이 가능하다.

### gRPC에 대해서 아시나요?
- Google Remote Procedure Call
- 구글에서 개발한 오픈소스 원격 프로시저 호출 프레임워크
- 프로토콜 버퍼를 데이터 직렬화 형식으로 사용
  - 프로토콜 버퍼 : 데이터를 컴팩트하고 빠르게 직렬화하고 역직렬화할 수 있는 형식
- HTTP/2를 기반, 낮은 지연 시간과 높은 처리량 제공, 효율적인 데이터 전송을 위해 바이너리 직렬화 형식 사용
- msa에서 유용하게 사용된다.

### (HTTP API(RESTful)와 비교했을 때)gRPC API는 어떤 이점을 제공하나요?