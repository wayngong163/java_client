package client;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class client_1 {
	private static int client_count = 0;
	private int client_id = 0;
	private Socket server = null;
	PrintWriter out;
	private static int time_count = 0;

	public client_1() throws Exception {
		client_id = client_count++;
		server = new Socket(InetAddress.getLocalHost(), 5678);
		PrintWriter out = new PrintWriter(server.getOutputStream());
	}

	public client_1(String address, int port) throws Exception {
		client_id = client_count++;
		server = new Socket(address, port);
		PrintWriter out = new PrintWriter(server.getOutputStream());
	}

	public client_1(int port) throws Exception {
		client_id = client_count++;
		server = new Socket(InetAddress.getLocalHost(), port);
		PrintWriter out = new PrintWriter(server.getOutputStream());
	}

	public void client_task() {
		String str = "send msg to server";
		System.out.println(str+time_count++);
		out.println(str);
		out.flush();
	}
}
