//package org.lyg.mainInterface;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//@Configuration
//public class WebmvcConfig implements HandlerInterceptor{
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		System.out.println("德塔发布系统正在运行中1...");	
////		String referer = request.getHeader("Referer");
////		response.setHeader("Access-Control-Allow-Origin", referer);
////		response.setHeader("strict-origin-when-cross-origin", "*");
//		return true;
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		System.out.println("德塔发布系统正在运行中2...");	
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		System.out.println("德塔发布系统正在运行中3...");
//	}
//
//}