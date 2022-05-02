package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.StudentEntity;
import com.example.demo.proxy.SchoolDto;
import com.example.demo.proxy.SchoolProxy;
import com.example.demo.service.StudentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
public class StudentController {
	
	private final SchoolProxy schoolProxy;
	private final StudentService studentService;
	private RestTemplate restTemplate;
	
	@PostMapping("/students")
	@CircuitBreaker(name = "school-circutebreacker", fallbackMethod = "schoolFallBack")
	public ResponseEntity<?> createStudent(@RequestBody StudentEntity studentEntity) {
		
		SchoolDto schoolDto = schoolProxy.getSchoolName(studentEntity.getSchoolName());
		log.info("here school proxyy is called");
		studentEntity.setSchoolName(schoolDto.getSchoolName());
		studentEntity.setAdmitedInSchool("student is admitted if scholl name is present");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentEntity));
	}
	
	@GetMapping("/schools")
	@CircuitBreaker(name = "school-circutebreacker", fallbackMethod = "schoolFallBack")
	public ResponseEntity<?> getAllSchools() {
		
		List<SchoolDto> schoolDto = restTemplate.getForObject("http://localhost:8888/SCHOOL-WS/allschools", List.class);
		
		return ResponseEntity.ok(schoolDto);
	}
	
	public ResponseEntity<?> schoolFallBack(Exception e) {
		
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("school name is not present or scoll-ws is server is down please try again afetr sometime!@#$");
	}
}