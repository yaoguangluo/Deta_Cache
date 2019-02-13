package org.lyg.vpc.process.portImpl;

import org.lyg.vpc.controller.port.RestCacheSerInf;
import org.lyg.vpc.utils.CollectSysInfoRatio;
import org.springframework.http.HttpRequest;

import java.util.List;

public class RestCacheSerInfImpl implements RestCacheSerInf {
    @Override
    public String getServerInf(HttpRequest request) throws Exception {
        //传送 缓存服务器的状态
        //获取 现存线程数， 可用内存，最大内存，已用内存，服务器cpu大小，硬盘容量

        String countThread= new CollectSysInfoRatio().getThreadCount()+"";
        String usedMemoryUsage=new CollectSysInfoRatio().getMemoryRatio();
        String avaMemoryUsage="";//TODO: 尝试使用sigar.jar计算
        String maxMemoryUsage="";//
        String cpuCapacity=new CollectSysInfoRatio().getCPURatio();
        List<String> hardDiskCap=new CollectSysInfoRatio().getDisk();


        if(request!=null && request.getURI().toString().toUpperCase().contains("SER")){
            return " request success! /r/n 缓存服务器基本信息, 现存线程数:" + countThread
                    +"/r/n 已用内存:" + usedMemoryUsage
                    +"/r/n 可用内存:" + avaMemoryUsage
                    +"/r/n 最大内存:" + maxMemoryUsage
                    +"/r/n 服务器cpu大小:" + cpuCapacity
                    +"/r/n 硬盘容量:" + hardDiskCap;

        }
        return "unsuccess";
    }

    @Override
    public String put(String key, String value) throws Exception {
        return null;
    }
}
