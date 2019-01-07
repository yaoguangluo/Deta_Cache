package org.deta.boot.rest;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class RestMap {
	public static void process(String[] type, Socket socket) throws IOException {
		String[] column = type[1].split("&");
		Map<String, String> data = new ConcurrentHashMap<>();
		for(String cell:column){
			String[] cells = cell.split("=");
			data.put(cells[0], URLDecoder.decode(cells[1], "UTF-8"));
		}
		String output = "";
		try {
			output = VPC.forward(type[0], data);
			PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
					.getOutputStream(),"UTF-8")),true);
			pw.println("HTTP/1.1 200 OK\n\n"); 
			output=output.charAt(0)=='"'?output.substring(1,output.length()):output;
			output=output.charAt(output.length()-1)=='"'?output.substring(0
					, output.length()-1):output;
			pw.println(output.replace("\\\"","\""));
			pw.flush();
			pw.close();
		} catch (Exception e) {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			pw.format("UTF-8", pw);
			pw.println("HTTP/1.1 500 OK\n\n"); 
			pw.println(output);
			pw.flush();
			pw.close();
		}	
	}
}