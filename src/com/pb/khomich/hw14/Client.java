package com.pb.khomich.hw14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Client start");
        String serverIp = "127.0.0.1";
        int serverPort  = 1234;
        System.out.println("Connecting to the server " + serverIp + ":" + serverPort);

        Socket server            = new Socket(serverIp, serverPort);
        BufferedReader inServer  = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter outServer    = new PrintWriter(server.getOutputStream(), true);
        BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

        String dataFromUser, dataFromServer;
        // Основной цикл отправки серверу
        while ((dataFromUser = inConsole.readLine()) != null) {
            outServer.println(dataFromUser);
            dataFromServer = inServer.readLine();
            //Печатаем ответ от сервера на консоль для проверки
            System.out.println(dataFromServer);
            //Для окончания посылаем в сообщении close
            if ("close".equalsIgnoreCase(dataFromUser)) {
                break;
            }
        }
        outServer.close();
        inServer.close();
        outServer.close();
        server.close();
    }
}
