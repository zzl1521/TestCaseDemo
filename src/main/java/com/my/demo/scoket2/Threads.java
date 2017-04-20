package com.my.demo.scoket2;

import java.io.IOException;

public class Threads implements Runnable{
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 3; i++) {
				ScoketClient.service();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}