package org.lyg.common.constants;

import org.lyg.vpc.utils.CollectSysInfoRatio;

import java.util.List;

public interface DetaDBConstant {
	//common
	final static int DIGIT_ONE = 1;
	final static int DIGIT_60000 = 60000;
	//Token expired.
	final static String ERRORCODE_ER1001 = "ER1001";

	//rest tire
	final static String REST_JSON_CONFIG = "application/json;charset=utf-8";
	final static String REST_LOGIN_LOGIN = "/login";
	final static String REST_LOGIN_LOGOUT = "/logout";
	final static String REST_LOGIN_REGISTER = "/register";
	final static String REST_LOGIN_FIND = "/find";
	final static String REST_LOGIN_CHANGE = "/change";

	final static String DB_LOGIN_U_NAME = "uName";
	final static String DB_LOGIN_U_CHANGE = "uChange";
	final static String DB_LOGIN_U_CHANGE_ENSURE = "uChangeEnsure";
	final static String DB_LOGIN_U_AGE = "uAge";
	final static String DB_LOGIN_U_EMAIL = "uEmail";
	final static String DB_LOGIN_U_EMAIL_ENSURE = "uEmailEnsure";
	final static String DB_LOGIN_U_ID = "uId";
	final static String DB_LOGIN_U_SEX = "uSex";
	final static String DB_LOGIN_U_PHONE = "uPhone";
	final static String DB_LOGIN_U_ADDRESS= "uAddress";
	final static String DB_LOGIN_U_WECHAT = "uWeChat";
	final static String DB_LOGIN_U_PSWD = "uPassword";
	final static String DB_LOGIN_U_PSWD_ENSURE = "uPasswordEnsure";
	final static String DB_LOGIN_U_PSTOKEN = "uToken";
	final static String DB_LOGIN_U_CLASS = "uClass";
	final static String DB_LOGIN_U_QQ = "uQq";

	//server tire
	//传送 缓存服务器的状态
	//获取 现存线程数， 可用内存，最大内存，已用内存，服务器cpu大小，硬盘容量

	final static String countThread= new CollectSysInfoRatio().getThreadCount()+"";
	final static String usedMemoryUsage=new CollectSysInfoRatio().getMemoryRatio();
	final static String avaMemoryUsage="";//TODO: 尝试使用sigar.jar计算
	final static String maxMemoryUsage="";//
	final static String cpuCapacity=new CollectSysInfoRatio().getCPURatio();
	final static List<String> hardDiskCap=new CollectSysInfoRatio().getDisk();


	//service tire

	//schedular tire

	//dao tire

	//database tire

	//condition tire

}
