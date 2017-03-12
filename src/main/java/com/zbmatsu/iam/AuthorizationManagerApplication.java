package com.zbmatsu.iam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.zbmatsu.iam.configuration.CustomConfigBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
@EnableConfigurationProperties({CustomConfigBean.class})
@ServletComponentScan
public class AuthorizationManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationManagerApplication.class, args);
	}
}