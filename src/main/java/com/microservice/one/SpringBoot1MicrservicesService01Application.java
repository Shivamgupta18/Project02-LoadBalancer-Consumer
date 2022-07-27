package com.microservice.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class SpringBoot1MicrservicesService01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1MicrservicesService01Application.class, args);
	}

}
