package org.deta.boot.controller;
import java.util.Map;
import org.lyg.common.maps.VtoV;
import org.lyg.vpc.process.portImpl.DevopsStatus;
public class DevopsController {
	public static String exec(String string, Map<String, String> data) throws Exception {
		if(string.equalsIgnoreCase("/devopsCache")){
			return VtoV.ObjectToJsonString(new DevopsStatus().getServerInf(data.get("token") ,data.get("email")
					, data.get("password")));
		}	
		return "";
	}
}