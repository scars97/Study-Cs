package org.example.Java.code.socket.ex03;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    TextArea txtDisplay;
    Button btnStartStop;
    ExecutorService executorService;
    ServerSocket serverSocket;
    List<Client> connections = new Vector<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(500, 300);

        txtDisplay = new TextArea();
        txtDisplay.setEditable(false);
        BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
        root.setCenter(txtDisplay);

        btnStartStop = new Button("start");
        btnStartStop.setPrefHeight(30);
        btnStartStop.setMaxWidth(Double.MAX_VALUE);

        // start와 stop 버튼을 클릭했을 때 이벤트 처리
        btnStartStop.setOnAction(event -> {
            if ("start".equals(btnStartStop.getText())) {
                startServer();
            } else {
                stopServer();
            }
        });
        root.setBottom(btnStartStop);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/app.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Server");
        // 윈도우 우측 상단 닫기 버튼 클릭 시 이벤트 처리
        primaryStage.setOnCloseRequest(event -> stopServer());
        primaryStage.show();
    }

    void displayText(String text) {
        txtDisplay.appendText(text + "\n");

    }


    void startServer() {
        executorService = Executors.newFixedThreadPool(
                // CPU 코어 수만큼 스레드를 만들도록 한다.
                Runtime.getRuntime().availableProcessors()
        );

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 8080));
        } catch (Exception e) {
            if (!serverSocket.isClosed()) {
                stopServer();
            }
            return;
        }

        // 수락 작업 생성
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    displayText("[서버 시작]");
                    btnStartStop.setText("stop");
                });

                while (true) {
                    try {
                        Socket socket = serverSocket.accept();
                        String message = "[연결 수락 : " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));

                        Client client = new Client(socket);
                        connections.add(client);
                        Platform.runLater(() -> displayText("[연결 개수: " + connections.size() + "]"));
                    } catch (Exception e) {
                        if (!serverSocket.isClosed()) {
                            stopServer();
                            break;
                        }
                    }
                }
            }
        };
        executorService.submit(runnable); // 스레드풀에서 처리
    }

    void stopServer() {
        try {
            // 모든 Socket 닫기
            Iterator<Client> iterator = connections.iterator();
            while (iterator.hasNext()) {
                Client client = iterator.next();
                client.socket.close();
                iterator.remove();
            }

            // ServerSocket 닫기
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }

            // ExecutorService 종료
            if (executorService != null && !executorService.isShutdown()) {
                executorService.shutdown();
            }
            Platform.runLater(() -> {
                displayText("[서버 멈춤]");
                btnStartStop.setText("start");
            });
        } catch (Exception e) {
        }
    }

    class Client {

        Socket socket;

        public Client(Socket socket) {
            this.socket = socket;
            receive();
        }

        void receive() {
            // 데이터 받기 작업 생성
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            byte[] byteArr = new byte[100];
                            InputStream inputStream = socket.getInputStream();

                            // 클라이언트가 비정상 종료를 했을 경우 IOException 발생
                            int readByteCount = inputStream.read(byteArr); // 데이터 받기

                            // 클라이언트가 정상적으로 Socket의 close() 를 호출한 경우
                            if (readByteCount == -1) throw new IOException();

                            String message = "[요청 처리 : " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
                            Platform.runLater(() -> displayText(message));

                            String data = new String(byteArr, 0, readByteCount, "UTF-8");

                            // 모든 클라이언트에게 데이터 전달
                            for (Client client : connections) {
                                client.send(data);
                            }
                        }
                    } catch (Exception e) {
                        try {
                            connections.remove(Client.this);
                            String message = "[클라이언트 통신 안됨 : " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
                            Platform.runLater(() -> displayText(message));
                            socket.close();
                        } catch (IOException e2) {

                        }
                    }
                }
            };
            executorService.submit(runnable);
        }

        void send(String data) {
            // 데이터 보내기 작업 생성
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        // 클라이언트로 데이터 보내기
                        byte[] byteArr = data.getBytes("UTF-8");
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write(byteArr);
                        outputStream.flush();

                    } catch (Exception e) {
                        try {
                            String message = "[클라이언트 통신 안됨 : " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
                            Platform.runLater(() -> displayText(message));
                            connections.remove(Client.this);
                            socket.close();
                        } catch (IOException e2) {
                        }
                    }
                }
            };
            executorService.submit(runnable);
        }
    }
}
