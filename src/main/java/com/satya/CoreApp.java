package com.satya;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableCaching
public class CoreApp { /*extends SpringBootServletInitializer  {
	//@Autowired private CodetablesRepo codetableRepo;
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	
        return application.sources(CoreApp.class);
    }*/
}