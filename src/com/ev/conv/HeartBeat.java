package com.ev.conv;

import java.io.OutputStream;
import java.net.Socket;

public class HeartBeat implements Runnable {

	private String vin;

	private Socket socket;

	public HeartBeat(String vin, Socket socket) {
		this.vin = vin;
		this.socket = socket;
	}

	@Override
	public void run() {

		String bcc = DataUtil.getBcc("07 FE " + vin + " 01 00 00");
		String packet = "23 23 07 FE " + vin + " 01 00 00 " + bcc;
		while (socket != null) {
			try {
				Thread.sleep(10000);
				// 向服务器端发送数据
				System.out.println("Send To Server: " + packet);

				OutputStream socketWriter = socket.getOutputStream();
				socketWriter.write(DataUtil.str2HexBytes(packet.trim()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}

	}

}
