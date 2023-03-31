package com.example.ms2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Ms2HwApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms2HwApplication.class, args);
	}

}
