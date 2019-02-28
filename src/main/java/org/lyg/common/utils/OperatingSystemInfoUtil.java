package org.lyg.common.utils;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.MBeanServerConnection;

//get original from CSDN SAMPLE:https://blog.csdn.net/zhongweijian/article/details/7619383
//Mr.Yaoguang Luo fixed as a new version. 20190301

@SuppressWarnings("unused")
public class OperatingSystemInfoUtil {
	public static void main(String[] args) {
		showJvmInfo();
		showMemoryInfo();
		showSystem();
		showClassLoading();
		showCompilation();
		showThread();
		showGarbageCollector();
		showMemoryManager();
		showMemoryPool();
	}

	/**
	 * Java 虚拟机的运行时系统
	 */
	public static Map<String, String>  showJvmInfo() {
		Map<String, String> map = new HashMap<>();
		RuntimeMXBean mxbean = ManagementFactory.getRuntimeMXBean();
		String vendor = mxbean.getVmVendor();
		map.put("jvm name:", mxbean.getVmName());
		map.put("jvm version:", mxbean.getVmVersion());
		map.put("jvm bootClassPath:", mxbean.getBootClassPath());
		map.put("jvm start time:", "" + mxbean.getStartTime());
		return map;	
//		System.out.println("jvm name:" + mxbean.getVmName());
//		System.out.println("jvm version:" + mxbean.getVmVersion());
//		System.out.println("jvm bootClassPath:" + mxbean.getBootClassPath());
//		System.out.println("jvm start time:" + mxbean.getStartTime());
	}

	/**
	 * Java 虚拟机的内存系统
	 */
	public static Map<String, String> showMemoryInfo() {
		Map<String, String> map = new HashMap<>();
		MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
		MemoryUsage heap = mem.getHeapMemoryUsage();
		map.put("Heap committed:", "" + heap.getCommitted());
		map.put("init:", "" + heap.getInit());
		map.put("max:", "" + heap.getMax());
		map.put("used:", "" + heap.getUsed());
		return map;
//		System.out.println("Heap committed:" + heap.getCommitted() + " init:" + heap.getInit() + " max:"
//				+ heap.getMax() + " used:" + heap.getUsed());
	}

	/**
	 * Java 虚拟机在其上运行的操作系统
	 */
	public static Map<String, String> showSystem() {
		Map<String, String> map = new HashMap<>();
		OperatingSystemMXBean op = ManagementFactory.getOperatingSystemMXBean();
		map.put("Architecture: ", "" + op.getArch());
		map.put("Processors: ", "" +  op.getAvailableProcessors());
		map.put("System name: ", "" + op.getName());
		map.put("System version: ", "" + op.getVersion());
		map.put("Last minute load: ", "" + op.getSystemLoadAverage());
		return map;	
//		System.out.println("Architecture: " + op.getArch());
//		System.out.println("Processors: " + op.getAvailableProcessors());
//		System.out.println("System name: " + op.getName());
//		System.out.println("System version: " + op.getVersion());
//		System.out.println("Last minute load: " + op.getSystemLoadAverage());
	}

	/**
	 * Java 虚拟机的类加载系统
	 */
	public static Map<String, String> showClassLoading(){
		Map<String, String> map = new HashMap<>();
		ClassLoadingMXBean cl = ManagementFactory.getClassLoadingMXBean();
		map.put("TotalLoadedClassCount: ", "" +cl.getTotalLoadedClassCount());
		map.put("LoadedClassCount", "" + cl.getLoadedClassCount());
		map.put("UnloadedClassCount:" , "" + cl.getTotalLoadedClassCount());	
		return map;	
//		System.out.println("TotalLoadedClassCount: " + cl.getTotalLoadedClassCount());
//		System.out.println("LoadedClassCount" + cl.getLoadedClassCount());
//		System.out.println("UnloadedClassCount:" + cl.getUnloadedClassCount());
	}

	/**
	 * Java 虚拟机的编译系统
	 */
	public static Map<String, String> showCompilation(){
		Map<String, String> map = new HashMap<>();
		CompilationMXBean com = ManagementFactory.getCompilationMXBean();
		map.put("TotalCompilationTime:", "" + com.getTotalCompilationTime());
		map.put("name:", "" +  com.getName());
		return map;
//		System.out.println("TotalCompilationTime:" + com.getTotalCompilationTime());
//		System.out.println("name:" + com.getName());
	}

	/**
	 * Java 虚拟机的线程系统
	 */
	public static Map<String, String> showThread(){
		Map<String, String> map = new HashMap<>();
		ThreadMXBean thread = ManagementFactory.getThreadMXBean();
		//......还有其他很多信息
		map.put("ThreadCount", "" + thread.getThreadCount());
		map.put("AllThreadIds:", "" +  thread.getAllThreadIds());
		map.put("CurrentThreadUserTime", "" + thread.getCurrentThreadUserTime());
		return map;
//		System.out.println("ThreadCount" + thread.getThreadCount());
//		System.out.println("AllThreadIds:" + thread.getAllThreadIds());
//		System.out.println("CurrentThreadUserTime" + thread.getCurrentThreadUserTime());
	}

	/**
	 * Java 虚拟机中的垃圾回收器。
	 */
	public static Map<String, Object> showGarbageCollector(){
		Map<String, Object> map = new HashMap<>();
		List<GarbageCollectorMXBean> gc = ManagementFactory.getGarbageCollectorMXBeans();
		for(GarbageCollectorMXBean GarbageCollectorMXBean : gc){
			Map<String, String> innerMap = new HashMap<>(); 
//			System.out.println("name:" + GarbageCollectorMXBean.getName()); 
//			System.out.println("CollectionCount:" + GarbageCollectorMXBean.getCollectionCount());
//			System.out.println("CollectionTime" + GarbageCollectorMXBean.getCollectionTime()); 
			innerMap.put("CollectionCount:", "" + GarbageCollectorMXBean.getCollectionCount());
			innerMap.put("CollectionTime", "" + GarbageCollectorMXBean.getCollectionTime());
			map.put(GarbageCollectorMXBean.getName(), innerMap);

		}
		return map;	
	}

	/**
	 * Java 虚拟机中的内存管理器
	 */
	public static Map<String, Object> showMemoryManager(){
		Map<String, Object> map = new HashMap<>();
		List<MemoryManagerMXBean> mm = ManagementFactory.getMemoryManagerMXBeans();
		for(MemoryManagerMXBean eachmm: mm){
			Map<String, String> innerMap = new HashMap<>();
//			System.out.println("name:" + eachmm.getName());
//			System.out.println("MemoryPoolNames:" + eachmm.getMemoryPoolNames().toString());
			innerMap.put("MemoryPoolNames:", "" + eachmm.getMemoryPoolNames().toString());
			map.put(eachmm.getName(), innerMap);
		}
		return map;	
	}

	/**
	 * Java 虚拟机中的内存池
	 */
	public static Map<String, Object> showMemoryPool(){
		Map<String, Object> map = new HashMap<>();
		List<MemoryPoolMXBean> mps = ManagementFactory.getMemoryPoolMXBeans();
		for(MemoryPoolMXBean mp : mps){
			Map<String, String> innerMap = new HashMap<>();
//			System.out.println("name:" + mp.getName());
//			System.out.println("CollectionUsage:" + mp.getCollectionUsage());
//			System.out.println("type:" + mp.getType());
			innerMap.put("CollectionUsage:", "" + mp.getCollectionUsage());
			innerMap.put("type:", "" + mp.getType());
			map.put(mp.getName(), innerMap);
		}
		return map;	
	}

	/**
	 * 访问 MXBean 的方法的三种方法
	 */
	public static  Map<String, String> visitMBean(){
		Map<String, String> map = new HashMap<>();
		RuntimeMXBean mxbean = ManagementFactory.getRuntimeMXBean();
		String vendor1 = mxbean.getVmVendor();
//		System.out.println("vendor1:" + vendor1);
		map.put("vendor1:", vendor1);
		return map;		
	}
}