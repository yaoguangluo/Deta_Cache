package org.lyg.vpc.controller.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test implements Runnable {
	Socket socket;
	public test(Socket socket) {
		this.socket = socket;
	}
	public static void main(String[] argv) throws IOException {
		Socket socket = new Socket("192.168.1.188", 6379);
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		test tt = new test(socket);
		TimeCheck t = new TimeCheck();
		t.begin();
		executorService.submit(tt);
		executorService.submit(tt);
		executorService.submit(tt);
		t.end();
		t.duration();
	}

	@Override
	public void run() {
		TimeCheck t = new TimeCheck();
		t.begin();
		try {
			for(int i=0;i<100000;i++) {
				PrintWriter os = new PrintWriter(socket.getOutputStream());
				os.println("/111");
				os.flush();
				InputStream is = socket.getInputStream();
				byte[] bytes=new byte[1024];
				;
				while((is.read(bytes, 0, 1024)) != -1) {
					//System.out.println("1"+new String(bytes)); 
				}		
			}
		}catch(Exception e) {

		}
		t.end();
		t.duration();
	}
}