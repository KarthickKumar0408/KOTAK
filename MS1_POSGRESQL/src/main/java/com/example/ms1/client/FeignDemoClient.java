package com.example.ms1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "hellowordMs2", url = "http://localhost:8082/")
public interface FeignDemoClient {
	

		   @GetMapping(value = "/api/getMessage")
		    public String getMessage();

}
