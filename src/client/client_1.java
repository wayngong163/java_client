package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

public class client_1 {
	private static int client_count = 0;
	private int client_id = 0;
	private Socket server = null;
	PrintWriter out;

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
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				int time_count = 0;
				String str = "send msg to server";
				System.out.println(str);
				try {
					Socket ser = new Socket(InetAddress.getLocalHost(), 5678);
					PrintWriter out_t = new PrintWriter(ser.getOutputStream());
					out_t.println(str);
					out_t.flush();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 1);// 设定指定的时间time,此处为1毫秒
	}
}
