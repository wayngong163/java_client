/**
 * 
 */
package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author GongKai
 *
 */
public class client {
	static Socket server;

	public static void main(String[] args) throws Exception {
		server = new Socket(InetAddress.getLocalHost(), 5678);
		BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
		PrintWriter out = new PrintWriter(server.getOutputStream());
		BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));

		client_1 c1 = new client_1(5678);
		c1.client_task();
		while (true) {
			String str = wt.readLine();
			out.println(str);
			out.flush();
			if (str.equals("end")) {
				break;
			}
			System.out.println(in.readLine());
			c1.client_task();
		}
		server.close();
	}
}
