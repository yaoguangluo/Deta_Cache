package org.deta.boot.rest;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class RestMap {
	@SuppressWarnings("deprecation")
	public static void process(String[] type, Socket socket) throws IOException {
		String[] column = type[1].split("&");
		Map<String, String> data = new ConcurrentHashMap<>();
		for(String cell:column){
			String[] cells = cell.split("=");
			data.put(cells[0], URLDecoder.decode(cells[1]));
		}
		String output = "";
		try {
			output = VPC.forward(type[0], data);
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			pw.println("HTTP/1.1 200 OK\n\n"); 
			pw.println(output.substring(1, output.length()-1).replace("\\\"","\""));
			pw.flush();
			pw.close();
		} catch (Exception e) {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			pw.println("HTTP/1.1 500 OK\n\n"); 
			pw.println(output);
			pw.flush();
			pw.close();
		}	
	}
}