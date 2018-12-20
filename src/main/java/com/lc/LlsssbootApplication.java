package com.lc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = {"com.lc.web.login.dao","com.lc.web.resource.dao"})
public class LlsssbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LlsssbootApplication.class, args);
	}
}
