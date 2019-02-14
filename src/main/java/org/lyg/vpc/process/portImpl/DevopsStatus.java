package org.lyg.vpc.process.portImpl;
import org.lyg.common.utils.DevopsUtil;
import java.util.List;
/*
 * 
 *     作者鲁骏。
 * */
public class DevopsStatus {
	public Object getServerInf(String token, String  usremail, String usrpswd) {
		//传送 缓存服务器的状态
		//获取 现存线程数， 可用内存，最大内存，已用内存，服务器cpu大小，硬盘容量
		String countThread= new DevopsUtil().getThreadCount()+"";
		String usedMemoryUsage=new DevopsUtil().getMemoryRatio();
		String avaMemoryUsage="";//TODO: 尝试使用sigar.jar计算
		String maxMemoryUsage="";//
		String cpuCapacity=new DevopsUtil().getCPURatio();
		List<String> hardDiskCap=new DevopsUtil().getDisk();
		//		if(request!=null && request.getURI().toString().toUpperCase().contains("SER")){
		//			return " request success! /r/n 缓存服务器基本信息, 现存线程数:" + countThread
		//					+"/r/n 已用内存:" + usedMemoryUsage
		//					+"/r/n 可用内存:" + avaMemoryUsage
		//					+"/r/n 最大内存:" + maxMemoryUsage
		//					+"/r/n 服务器cpu大小:" + cpuCapacity
		//					+"/r/n 硬盘容量:" + hardDiskCap;
		//
		//		}
		return "unsuccess";
	}
}