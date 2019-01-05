package org.lyg.vpc.controller.port;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.lyg.common.RequestLimit;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import static org.lyg.common.constants.DetaDBConstant.DIGIT_60000;
import static org.lyg.common.constants.DetaDBConstant.DIGIT_ONE;
import static org.lyg.common.constants.DetaDBConstant.REST_JSON_CONFIG;

import java.util.List;
@RestController
public interface RestCachePort {
	@RequestLimit(count = DIGIT_ONE, time = DIGIT_60000)
	@POST
	@RequestMapping("/get")
	@Produces(REST_JSON_CONFIG)
	String get(@QueryParam("key") String key
			, @QueryParam("email") String email
			, @QueryParam("password") String password) throws Exception;
	
	@RequestLimit(count = DIGIT_ONE, time = DIGIT_60000)
	@POST
	@RequestMapping("/put")
	@Produces(REST_JSON_CONFIG)
	String put(@QueryParam("key") String key
			, @QueryParam("value") String value
			, @QueryParam("time") String time
			, @QueryParam("email") String email
			, @QueryParam("password") String password) throws Exception;
	
	@RequestLimit(count = DIGIT_ONE, time = DIGIT_60000)
	@POST
	@RequestMapping("/getAskers")
	@Produces(REST_JSON_CONFIG)
	List<String> getAskers(@QueryParam("email") String email
			,@QueryParam("password") String password) throws Exception;

}