package org.deta.boot.server;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.deta.boot.thread.SocketThread;
import org.deta.boot.thread.SocketThreadPool;

public class ApplicationBoot {
	private static ServerSocket server;
	private static Properties properties;
	private int port;
	static {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("src/main/resources/property.proterties")));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void init() {
		try {
			port = Integer.parseInt(properties.getProperty("port"));
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		SocketThreadPool socketThreadPool = new SocketThreadPool();
		ApplicationBoot boot = new ApplicationBoot();
		boot.init();
		boot.addRestService();
		System.out.println("----µÂËþHTTP·þÎñÆ÷----");
		ExecutorService executorService = Executors.newFixedThreadPool(100);
		while(true) {
			if(socketThreadPool.getThreadsCount() < 1000){
				SocketThread clientSocket = new SocketThread(socketThreadPool, server.accept()
						, System.currentTimeMillis() + "" + new Random().nextLong());
				socketThreadPool.addExecSocket(clientSocket.getSid(), clientSocket);
				executorService.submit(clientSocket);
			}
		}
	}

	private void addRestService() {
		// TODO Auto-generated method stub

	}
}