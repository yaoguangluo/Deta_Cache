package org.lyg.mainInterface;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class SessionInterceptor extends WebMvcConfigurerAdapter{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new WebmvcConfig()).addPathPatterns("/**").excludePathPatterns("/*"
				,"/js/**"
				,"/bootstrap/**"
				,"/css/**"
				,"/fonts/**"
				,"/test/**"
				,"/images/**"
				,"/plugins/**");
		super.addInterceptors(registry);
	}
}