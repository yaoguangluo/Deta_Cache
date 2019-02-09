package org.lyg.cache;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
public class DetaCacheManager {
	private static ConcurrentHashMap<String, DetaCache> cacheMap = new ConcurrentHashMap<>();
	private DetaCacheManager() {
		super();
	}
	
	public static String putCache(String key, String value, long timeOut){
		DetaCache c = new DetaCache();
		c.setValue(value);
		if(0 == timeOut && cacheMap.containsKey(key)){
			c.setTimeOut(cacheMap.get(key).getTimeOut());
		}else{
			c.setTimeOut(timeOut);
		}
		cacheMap.put(key, c);
		return "success";
	}

	public static String getCache(String key){
		DetaCache c = cacheMap.get(key);
		if(null == c){
			return "unsuccess nofind cache";	
		}
		long now = System.currentTimeMillis();
		if(c.getTimeOut() < now){
			cacheMap.remove(key);
			return "unsuccess timeout";	
		}
		return c.getValue();
	}
	
	@SuppressWarnings("rawtypes")
	public static Iterator getCacheIterator(){
		return cacheMap.entrySet().iterator(); 
	}
} 