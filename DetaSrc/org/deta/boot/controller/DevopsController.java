package org.deta.boot.controller;
import java.util.HashMap;
import java.util.Map;
import org.lyg.common.maps.VtoV;
import org.lyg.common.utils.GzipUtil;
import org.lyg.common.utils.SniperSecurity;
import org.lyg.vpc.process.portImpl.DevopsStatus;
public class DevopsController {
	public static String exec(String string, Map<String, String> data) throws Exception {
		if(string.equalsIgnoreCase("/devopsCache")){

			Map<String, String> response = new HashMap<String, String>();
			response.put("status","success");
			response.put("sniperkey","sniper");
			response.put("contentRSA", SniperSecurity.encrypt(new DevopsStatus().getServerInf(data.get("token") ,data.get("email")
					, data.get("password"))) );

			return VtoV.ObjectToJsonString(GzipUtil.compress(VtoV.ObjectToJsonString(response),""));
		}	
		return "";
	}
}