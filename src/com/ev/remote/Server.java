package com.ev.remote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
	public static final int PORT = 19006;// 监听的端口号

	public static void main(String[] args) {
		System.out.println("Server start...\n");
		Server server = new Server();
		server.init();
	}

	@SuppressWarnings("resource")
	public void init() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while (true) {
				// 一旦有堵塞, 则表示服务器与客户端获得了连接
				Socket client = serverSocket.accept();
				// 处理这次连接
				new HandlerThread(client);
			}
		} catch (Exception e) {
			System.out.println("server exception: " + e.getMessage());
		}
	}

	Map<String, Integer> vehicleMap = new ConcurrentHashMap<String, Integer>();
	Map<String, Integer> platformMap = new ConcurrentHashMap<String, Integer>();

	private class HandlerThread implements Runnable {
		private Socket socket;

		public HandlerThread(Socket client) {
			socket = client;
			new Thread(this).start();
		}

		public void run() {
			try {
				// 读取客户端数据
				DataInputStream input = new DataInputStream(socket.getInputStream());
				String clientInputStr = input.readUTF();// 这里要注意和客户端输出流的写方法对应,否则会抛
														// EOFException
				// 处理客户端数据
				System.out.println("Receive from client:" + clientInputStr);

				String[] inBytes = clientInputStr.split(" ");
				String response = "not accepted.";
				if (inBytes.length > 21) {
					String cmd = inBytes[2];
					String[] vinarr = new String[17];
					System.arraycopy(inBytes, 4, vinarr, 0, 17);
					String vin = Arrays.toString(vinarr);
					if ("01".equals(cmd)) {
						int loginCount = 0;
						if (vehicleMap.containsKey(vin)) {
							loginCount = vehicleMap.get(vin) + 1;
						} else {
							loginCount = 1;
						}
						vehicleMap.put(vin, loginCount);
						response = "Vehicle Login OK. Login count: " + loginCount;
					} else if ("02".equals(cmd)) {
						if (!vehicleMap.containsKey(vin)) {
							response = "Vehicle Not Login.";
						} else {
							response = "Received.";
						}
					} else if ("04".equals(cmd)) {
						if (!vehicleMap.containsKey(vin)) {
							response = "Vehicle Not Login.";
						} else {
							response = "Vehicle Logout OK.";
							vehicleMap.remove(vin);
						}
					} else if ("05".equals(cmd)) {
						int loginCount = 0;
						if (platformMap.containsKey(vin)) {
							loginCount = platformMap.get(vin) + 1;
						} else {
							loginCount = 1;
						}
						platformMap.put(vin, loginCount);
						response = "Platform Login OK. Login count: " + loginCount;
					} else if ("06".equals(cmd)) {
						if (!platformMap.containsKey(vin)) {
							response = "Platform Not Login.";
						} else {
							response = "Platform Logout OK.";
							platformMap.remove(vin);
						}
					}
				} else {
					if ("bye".equals(clientInputStr)) {
						response = "bye";
					}
				}

				// 向客户端回复信息
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				out.writeUTF(response);

				out.close();
				input.close();
			} catch (Exception e) {
				System.out.println("Server exception: " + e.getMessage());
				e.printStackTrace();
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (Exception e) {
						socket = null;
						System.out.println("server finally exception:" + e.getMessage());
					}
				}
			}
		}
	}
}