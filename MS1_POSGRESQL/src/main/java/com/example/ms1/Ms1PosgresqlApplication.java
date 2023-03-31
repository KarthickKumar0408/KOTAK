package com.example.ms1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class Ms1PosgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms1PosgresqlApplication.class, args);
	}

}
