## Socket

Java에서 소켓 통신을 할 때, ServerSocket과 Socket를 사용할 수 있다.
- 클라이언트의 연결 요청을 기다리면서 연결 수락을 담당하는 ServerSocket
- 연결된 클라이언트와 통신을 담당하는 Socket
- 클라이언트가 연결 요청을 하면 ServerSocket은 연결을 수락하고 통신용 Socket 을 만든다.

### ServerSocket
- 서버는 클라이언트가 접속할 포트를 가지고 있어야 하는데, 이 포트를 바인딩 포트라 한다.
- ServerSocket을 생성할 때 바인딩 포트를 대입한다.
- 만약 해당 포트가 다른 프로그램에서 사용 중이라면 BindException이 발생한다.
- ServerSocket은 클라이언트 연결 수락을 위해 accept() 을 실행해야 한다.
  - accept() 는 클라이언트가 연결 요청하기 전까지 블로킹된다.
- 클라이언트가 연결 요청하면 통신할 Socket을 만들고 리턴한다.
```java
// 1
ServerSocket serverSocket = new ServerSocket(8080);
serverSocket.accept();

// 2
ServerSocket serverSocket = new ServerSocket();
serverSocket.bind(new InetSocketAddress(8080))
serverSocket.accept();
```

### Socket
- Socket 객체를 생성함과 동시에 연결 요청을 하려면 서버의 IP 주소와 바인딩 포트 번호를 매개값으로 제공해야 한다.
- IP 대신 도메인 이름만 알고 있다면, 도메인 이름을 IP 주소로 번역해야 하므로 InetSocketAddress 를 사용해야 한다.
```java
// 1
Socket socket = new Socket("서버 IP 주소", 8080);
socket.connect();

// 2
Socket socket = new Socket();
socket.connect(new InetSocketAddress("도메인 이름", 8080));
```

### Socket 데이터 통신
- 클라이언트와 서버가 연결되었다면 양쪽의 Socket으로부터 각각 입력 스트림과 출력 스트림을 얻을 수 있다.
```java
// 클라이언트 기준
String message = "Hello Server";
byte[] bytes= message.getBytes("UTF-8");

OutputStream os = socket.getOutputStream();
os.write(bytes);
os.flush();
System.out.println("데이터 보내기 성공");

bytes = new byte[100];
InputStream is = socket.getInputStream();
int readByteCount = is.read(bytes);
message = new String(bytes, 0, readByteCount, "UTF-8");
System.out.println("데이터 받기 성공: " + message);
```
- 데이터를 받기 위해 InputStream의 read() 를 호출하면 상대방이 데이터를 보내기 전까지 블로킹된다.
- read() 가 블로킹 해제되고 리턴되는 경우
  - 상대방이 데이터를 보냄
  - 상대방이 정상적으로 Socket 의 close() 를 호출
  - 상대방이 비정상적으로 종료 -> IOException 발생

### ServerSocket 과 Socket은 동기 방식으로 구동된다.
- 연결 수락을 위해 accept(), 연결 요청을 위해 connect() 를 실행할 경우, 해당 작업이 완료되기 전까지 블로킹 된다.
- InputStream의 read() 는 상대방이 데이터를 보내기전까지 블로킹되며, OutStream의 write() 는 데이터를 완전히 보내기 전까지 블로킹된다.