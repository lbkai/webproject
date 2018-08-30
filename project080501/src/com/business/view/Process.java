package com.business.view;

import java.io.IOException;

public class Process {
	public static  String  input() {
		byte[] buf = new byte[50];
		try {
			System.in.read(buf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(buf).trim();
	}
}
