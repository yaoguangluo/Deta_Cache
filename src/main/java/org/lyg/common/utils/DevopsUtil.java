package org.lyg.common.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.log4j.Logger;
import org.json.JSONObject;
/*
 * 
 *     作者鲁骏。
 * */
@SuppressWarnings("unused")
public class DevopsUtil {

	private String isWindowsOrLinux = isWindowsOrLinux();
	public Logger log = Logger.getLogger(DevopsUtil.class);

    public static void main(String[] args) throws Exception {

        System.out.println(isWindowsOrLinux()+"\r\n");
	    System.out.println(getServerStatus());
    }

	/**
	 * 判断是服务器的系统类型是Windows 还是 Linux
	 *
	 * @return
	 */
	public static String isWindowsOrLinux() {
		String osName = System.getProperty("os.name");
		String sysName = "";
		if (osName.toLowerCase().startsWith("windows")) {
			sysName = "windows";
		} else if (osName.toLowerCase().startsWith("linux")) {
			sysName = "linux";
		}
		return sysName;
	}

	public static String getServerStatus() throws Exception {

	    if(isWindowsOrLinux().equalsIgnoreCase("windows")){
	        return WinServerUtil.getWinServerStatus();
        }
        else{
	        return LinuxServerUtil.getLinuxServerStatus();
        }
    }

}