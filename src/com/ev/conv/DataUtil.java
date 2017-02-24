package com.ev.conv;

import java.util.Arrays;

public class DataUtil {

	public static final int[] HEX_VALUES = { 0, 0xFF, 0xFFFF, 0, 0xFFFFFFFF, 0 };

	public static void main(String[] args) {

		String packet = "23 23 06 FE 31 46 54 45 57 31 45 47 30 47 4B 44 32 30 31 39 31 01 00 00 B9";
		String data = packet.substring(6, packet.lastIndexOf(" "));
		String bcc = DataUtil.getBcc(data);
		String newPacket = packet.substring(0, packet.lastIndexOf(" ")) + " " + bcc;
		System.out.println(packet);
		System.out.println(newPacket);

	}

	public static String str2Hex(String str) {

		byte[] bytes = str.getBytes();
		int length = bytes.length;
		String out = "";
		for (int i = 0; i < length; i++) {
			out = out + Integer.toHexString(bytes[i] & 0xFF).toUpperCase() + " ";
		}
		return out.trim();
	}

	public static byte[] str2HexBytes(String str) {

		String[] arr = str.trim().split(" ");
		byte[] out = new byte[arr.length];
		for (int i = 0; i < arr.length; i++) {
			out[i] = (byte) (Integer.valueOf(arr[i], 16) & 0xFF);
		}

		return out;
	}

	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private static byte toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	public static String dec2Hex(String value, int length) {
		return dec2Hex(Integer.valueOf(value), length);
	}

	public static String dec2Hex(int value, int length) {

		byte[] out = new byte[length * 2];
		Arrays.fill(out, (byte) (48 & 0xFF));

		String hexstr = Integer.toHexString(value & HEX_VALUES[length]);
		byte[] hexval = hexstr.getBytes();
		System.arraycopy(hexval, 0, out, length * 2 - hexval.length, hexval.length);

		String outstr = "";
		for (int i = 0; i <= out.length - 2; i = i + 2) {
			String a = new String(new byte[] { out[i], out[i + 1] });
			outstr = outstr + a.toUpperCase() + " ";
		}

		return outstr.trim();
	}

	public static String dec2Bin(int value, int length) {

		byte[] out = new byte[length * 8];
		Arrays.fill(out, (byte) (48 & 0xFF));

		String binstr = Integer.toBinaryString(value);
		byte[] hexval = binstr.getBytes();
		System.arraycopy(hexval, 0, out, length * 8 - hexval.length, hexval.length);

		return new String(out);
	}

	public static String getBcc(String data) {
		String[] ss = data.split(" ");

		String a = ss[0];
		int f = 0;
		for (int i = 1; i < ss.length; i++) {
			String b = ss[i];
			int ai = Integer.valueOf(a, 16);
			int bi = Integer.valueOf(b, 16);
			f = ai ^ bi;

			a = Integer.toHexString(f);
		}

		String out = Integer.toHexString(f).toUpperCase();
		if (out.length() == 1)
			return "0" + out;
		return out;
	}

	public static String hex2Str(String val) {
		String str = "";
		String[] arr = val.split(" ");
		for (int i = 0; i < arr.length; i++) {
			char a = (char) (Integer.parseInt(arr[i], 16));
			str = str + a;
		}

		return str;
	}

	public static int hex2Dec(String val) {

		return Integer.parseInt(val.replace(" ", ""), 16);
	}

	public static String byteArr2HexStr(byte[] out) {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < out.length; i++) {
			str.append(Integer.toHexString(out[i]) + " ");
		}

		return str.toString().trim();
	}

}
