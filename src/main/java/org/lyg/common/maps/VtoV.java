package org.lyg.common.maps;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
//import org.jboss.resteasy.spi.HttpRequest;
import org.json.JSONObject;
import org.json.XML;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
@SuppressWarnings("unused")
public class VtoV{
	public JSONObject XmlToJsonObject(String response ){
		JSONObject responseJson = XML.toJSONObject(response);
		return responseJson;
	}

	public Map<String, Object> JsonObjectToMap(JSONObject response ){
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Object>>(){}.getType();
		Map<String, Object> responseMap =gson.fromJson(response.toString(), type);
		return responseMap;
	}

	public String MapToJsonString(Map<String, Object> response ){
		Gson gson = new Gson();
		return gson.toJson(response);
	}

	public Map<String, Object> XmlToMap(String response){
		JSONObject responseJson = XML.toJSONObject(response);
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Object>>(){}.getType();
		Map<String, Object> responseMap =gson.fromJson(responseJson.toString(), type);
		return responseMap;
	}

	public String MapToXml(Map<String, Object> response){
		Gson gson = new Gson();
		String json = gson.toJson(response);
		JSONObject jsonObj = new JSONObject(json);
		String xml = XML.toString(jsonObj);
		return xml;	
	}
}