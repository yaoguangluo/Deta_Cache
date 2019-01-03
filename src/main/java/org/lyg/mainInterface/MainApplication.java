package org.lyg.mainInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ImportResource(locations = {"classpath:/application-context.xml"})
@ComponentScan
public class MainApplication extends SpringBootServletInitializer 
implements EmbeddedServletContainerCustomizer {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(6379);
	}
}