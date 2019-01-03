package org.lyg.common.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
public class DetaDBUtil {
	@SuppressWarnings("deprecation")
	public static String DBRequest(String request) throws IOException {
		URL url = new URL("http://localhost:3306/" + URLEncoder.encode(request));
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()),"UTF-8"));
		String out = "";
		String out1;
		while ((out1 = br.readLine()) != null) {
			out += out1;
		}
		conn.disconnect();
		return out;
	}
}