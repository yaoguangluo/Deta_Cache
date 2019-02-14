package org.deta.boot.rest;
import java.util.Map;

import org.lyg.common.maps.VtoV;
import org.lyg.vpc.process.portImpl.RestCachePortImpl;
public class VPC {
	public static String forward(String string, Map<String, String> data) throws Exception {
		if(string.equalsIgnoreCase("/111")){
			return new VtoV().ObjectToJsonString("success");	
		}
		if(string.equalsIgnoreCase("/getAskers")){
			return new VtoV().ObjectToJsonString(new RestCachePortImpl().getAskers(data.get("email"), data.get("password")));	
		}
		if(string.equalsIgnoreCase("/get")){
			return new VtoV().ObjectToJsonString(new RestCachePortImpl().get(data.get("key"), data.get("email")
					,  data.get("password")));	
		}
		if(string.equalsIgnoreCase("/put")){
			return new VtoV().ObjectToJsonString(new RestCacheSerInfImpl().put(data.get("key"), data.get("value")
					,data.get("time")  , data.get("email"), data.get("password")));	
		}

        if(string.equalsIgnoreCase("/getSerInf")){
            return new VtoV().ObjectToJsonString(new RestCacheSerInfImpl().getServerInf(data.get("request"));
        }

		return "";
	}
}