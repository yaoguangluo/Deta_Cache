package org.deta.boot.press.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class restPressTest {
	@SuppressWarnings({ "deprecation", "unused" })
	public static void main(String[] args) throws IOException {
		for(int i=0;i<1;i++){
			URL url = new URL("http://localhost:8080/" + URLEncoder.encode("313%$#@&\n\n\thfr398hf38rhf39r8hf3r98hf3r98fh3r98hf398rfh398rfh893rhf83r9fh3r98fh3r89fh3r8hf3r8hffbvufevu3rfh"));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()),"UTF-8"));
			String out1;
			while ((out1 = br.readLine()) != null) {
			}
			conn.disconnect();
		}
	}
}