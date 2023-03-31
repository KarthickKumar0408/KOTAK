package com.example.ms2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AutomatedController {

	@GetMapping("/api/getMessage")
	public String getMessage() {
		return "Hello World";
	}
}
