package org.lyg.vpc.controller.port;

import org.eclipse.jetty.websocket.server.ServletWebSocketRequest;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.lyg.common.RequestLimit;

import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import static org.lyg.common.constants.DetaDBConstant.DIGIT_60000;
import static org.lyg.common.constants.DetaDBConstant.DIGIT_ONE;
import static org.lyg.common.constants.DetaDBConstant.REST_JSON_CONFIG;

import java.util.List;

@RestController("server")
public interface RestCacheSerInf {

    @RequestLimit(count = DIGIT_ONE, time = DIGIT_60000)
    @GET
    @RequestMapping("/getSerInf")
    @Produces(REST_JSON_CONFIG)
    String getServerInf(HttpRequest request) throws Exception;


    @RequestLimit(count = DIGIT_ONE, time = DIGIT_60000)
    @POST
    @RequestMapping("/putBasicInf")
    @Produces(REST_JSON_CONFIG)
    String put(@QueryParam("ip") String key
            , @QueryParam("port") String value) throws Exception;

}
