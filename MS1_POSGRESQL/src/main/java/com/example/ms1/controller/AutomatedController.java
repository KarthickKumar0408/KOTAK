package com.example.ms1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms1.client.FeignDemoClient;
import com.example.ms1.model.Element;
import com.example.ms1.repo.ElementRepo;

@RestController
public class AutomatedController {

	@Autowired
	private ElementRepo elementRepo;
	@Autowired
	private FeignDemoClient feignClient;

	@GetMapping("/api/elements")
	public List<Element> getAllElements() {
		return (List<Element>) elementRepo.findAll();
	}

	@PostMapping("/api/createElement")
	public Element createElement(@RequestBody Element element) {
		return elementRepo.save(element);
	}

	@PutMapping("/api/element/{id}")
	public ResponseEntity<Element> updateElement(@PathVariable(value = "id") int elementId,
			@RequestBody Element elementDetails) {
		Element updatedElement = null;
		Element element = elementRepo.findById(elementId).orElse(null);
		if (element != null) {
			element.setElementName(elementDetails.getElementName());
			element.setHostName(elementDetails.getHostName());
			element.setIpAddress(elementDetails.getIpAddress());
			element.setSubnetMask(elementDetails.getSubnetMask());
			updatedElement = elementRepo.save(element);
		}

		return ResponseEntity.ok(updatedElement);
	}

	@DeleteMapping("/api/element/{id}")
	public Map<String, Boolean> deleteElement(@PathVariable(value = "id") int elementId) {
		Element element = elementRepo.findById(elementId).orElse(null);
		if (element != null)
			elementRepo.delete(element);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping("/api/getMessage")
	public String getMessage() {
		return feignClient.getMessage();

	}

}
