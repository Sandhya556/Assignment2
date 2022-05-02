package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SchoolEntity;
import com.example.demo.service.SchoolService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SchoolController {
	private final SchoolService schoolService;
	
	@GetMapping("/school/{schoolName}")
	public SchoolEntity findASchoolByName(@PathVariable("schoolName") String schoolName) {
		return schoolService.findASchoolByName(schoolName);
	}
	@GetMapping("/allschools")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(schoolService.getAll());
	}

}
