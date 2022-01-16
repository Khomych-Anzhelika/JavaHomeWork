package com.pb.khomich.hw15;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;


import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class Chat {
    private JButton btnMsgSend;
    private JTextField fieldMsg;
    private JTextField fieldClientName;
    private JPanel Chat;
    private JTextArea histMsg;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Chat() throws IOException {

        try {
            //параметры для подключения к серверу
            this.socket = new Socket("localhost", 1234);

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            //поток для получения сообщений с сервера
            new Thread(() -> {
                while (true) {
                    try {
                        String fromServer = reader.readLine();
                        //allMsg = allMsg + fromServer;
                        histMsg.append(fromServer);
                        // добавляем строку перехода
                        histMsg.append("\n");

                    } catch (IOException e) {
                        writer.println(fieldClientName.getText() + " вышел из чата!");
                        writer.flush();

                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        histMsg.append("Соединение с сервером прервано");
                        histMsg.append("\n");
                        //System.exit(0);
                        break;
                    }
                }
            }).start();

            //Отправка сообщений по нажатию на кнопку "Отправить"
            btnMsgSend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //логин и текст сообщения
                    String message = fieldClientName.getText() + ": " + fieldMsg.getText();
                    writer.println(message);
                    writer.flush();
                    fieldMsg.setText("");
                }
            });


            // добавляем обработчик события закрытия окна клиентского приложения
            addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {
                    System.out.println("Выход 1");
                    writer.println(fieldClientName.getText() + " вышел из чата!");
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    super.windowClosing(e);
                    try {
                        System.out.println("Выход 2");
                        writer.flush();
                        writer.close();
                        reader.close();
                        //wait(1000);
                        socket.close();
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                }
            });

        } catch (IOException e) {
            //если сервер выключен приложение загрузится но в чате будет сообщение
            System.err.println("Ошибка подключения к ЧАТ серверу.");
            histMsg.append("Соединение с сервером НЕ установлено.\nЗакройте приложение.");
        }
    }

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("Chat");
        frame.setContentPane(new Chat().Chat);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
