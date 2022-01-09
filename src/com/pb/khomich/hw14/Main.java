package com.pb.khomich.hw14;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {

		// �������� ��� ����� � ������� ���������� ��������� ����� ���������� - 10-�.
		ExecutorService exec = Executors.newFixedThreadPool(10);
		int j = 0;

		// �������� ���� � ������� � ������ � 10 ���������� �������� Runnable
		// ��������, ������� ����� �����-�� ���������� ���������
		while (j < 10) {
			j++;
			exec.execute(new Client());
			Thread.sleep(10);
		}
		
		// ��������� �������
		exec.shutdown();
	}
}
