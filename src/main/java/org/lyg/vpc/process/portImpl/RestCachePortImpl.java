package org.lyg.vpc.process.portImpl;
import org.lyg.cache.DetaCacheManager;
import org.lyg.vpc.controller.port.RestCachePort;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RestCachePortImpl implements RestCachePort {
	
	@Override
	public String get(String key, String email, String password) throws Exception {
		if(email.equalsIgnoreCase("313699483@qq.com") && password.equalsIgnoreCase("Fengyue1985!")){
			return DetaCacheManager.getCache(key);
		}
		return "unsuccess";
	}

	@Override
	public String put(String key, String value, String time, String email, String password)
			throws Exception {
		if(email.equalsIgnoreCase("313699483@qq.com") && password.equalsIgnoreCase("Fengyue1985!")){
			DetaCacheManager.putCache(key, value, Long.valueOf(time));
			return "success";
		}
		return "unsuccess";
	}
}