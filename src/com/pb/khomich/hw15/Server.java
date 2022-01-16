package com.pb.khomich.hw15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": Customer request received");

                BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter    out = new PrintWriter(socket.getOutputStream(), true);

                String clientMessage;
                System.out.println("Waiting for messages");
                while ((clientMessage = in.readLine()) != null) {
                    if ("Close".equalsIgnoreCase(clientMessage)) {
                        break;
                    }
                    out.println("Server: "+ (LocalDateTime.now().toString()) + " " + clientMessage);
                    System.out.println(Thread.currentThread().getName() + " -> " + clientMessage);
                }
                System.out.println("Closing the client connection in the stream: " + Thread.currentThread().getName());
                out.close();
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception ex) {
                    // ignore
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started: " + port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        // В цикле ждем запроса клиента
        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}