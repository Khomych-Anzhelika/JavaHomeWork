package com.pb.khomich.hw14;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

	static Socket socket;

	public Client() {
		try {

			// ������ ����� ������� �� ������� ������� � ������������ �������
			socket = new Socket("localhost", 1777);
			System.out.println("�������� ����� � ���");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		try (
			DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
			DataInputStream ois = new DataInputStream(socket.getInputStream())) {

			int i = 0;
			// ������ ������� ����
			while (i < 5) {
				Scanner scanAdd = new Scanner(System.in);
				System.out.println("������� ���������:");
				String txt = scanAdd.nextLine();
				// ����� ��������� ���������������� ������ ������� � �����
				// ������ ��� �������
				oos.writeUTF("������������ �������: " + txt);
				// ������������ ��������� �� ������ ������� ��������� � �����
				oos.flush();

				// ��� ����� ������ ����� �������� ��������� �� ������ �
				// ��������
				Thread.sleep(10);
				System.out.println("Client wrote & start waiting for data from server...");

				// �������� ����� �� ������ ������� � ������
				// ������� � ���������� � ois ����������, �������� ��
				// �������
				System.out.println("reading...");
				String in = ois.readUTF();
				System.out.println(in);
				i++;
				Thread.sleep(5000);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
