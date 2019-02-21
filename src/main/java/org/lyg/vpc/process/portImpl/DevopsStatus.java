package org.lyg.vpc.process.portImpl;
import org.lyg.common.RequestLimit;
import org.lyg.common.utils.DevopsUtil;
import org.lyg.common.utils.SniperSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static org.lyg.common.constants.DetaDBConstant.DIGIT_60000;
import static org.lyg.common.constants.DetaDBConstant.DIGIT_ONE;
import static org.lyg.common.constants.DetaDBConstant.REST_JSON_CONFIG;

/*
 * 
 *     作者鲁骏。
 *     罗瑶光进行了功能调通的修改
 * */
@RestController
public class DevopsStatus{

    @RequestLimit(count = DIGIT_ONE, time = DIGIT_60000)
    @POST
    @RequestMapping("/devopsCache")
    @Produces(REST_JSON_CONFIG)
    public String getServerInf(@QueryParam("token") String key
            , @QueryParam("email") String email
            , @QueryParam("password") String password) throws Exception {

		//传送 缓存服务器的状态
		//获取 现存线程数， 可用内存，最大内存，已用内存，服务器cpu大小，硬盘容量
		System.out.println(email+" :  "+password);
		if(email.equalsIgnoreCase("313699483@qq.com") && SniperSecurity.decrypt(password).equalsIgnoreCase("Fengyue1985!")){
//
            return "request success! \r\n Cache Server \r\n" + DevopsUtil.getServerStatus();
				}
		
		return "unsuccess";
    }
}