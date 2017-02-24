package com.ev.remote;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import com.ev.conv.DataUtil;

public class Client {
	public static final String IP_ADDR = "153.3.127.61";// 服务器地址
	public static final int PORT = 19006;// 服务器端口号

	public static void main(String[] args) {
		System.out.println("Client start...");
		System.out.println("You can send specific data packet now ...");
		System.out.println(
				"Supported: Vehicle Login/Vehicle Logout/Real-time Data Report/Platform Login/Platform Logout ...");
		Socket socket = null;
		try {

			socket = new Socket(IP_ADDR, PORT);
			while (true) {
				// 创建一个流套接字并将其连接到指定主机上的指定端口号
				System.out.print("Please Input: \t");
				InputStream input = socket.getInputStream();
				String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
				OutputStream socketWriter = socket.getOutputStream();
				socketWriter.write(DataUtil.str2HexBytes(str));

				byte[] out = new byte[input.available()];
				input.read(out);

				System.out.println("Response from Server: " + DataUtil.byteArr2HexStr(out));
				// out.close();
				// input.close();
			}
		} catch (Exception e) {
			System.out.println("Client exception:" + e.getMessage());
			e.printStackTrace();
		}

	}
}