package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.model.SchoolEntity;
import com.example.demo.repo.SchoolRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
@EnableEurekaClient
public class SchoolWsApplication {
	
	private final SchoolRepository schoolRepository;

	public static void main(String[] args) {
		SpringApplication.run(SchoolWsApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		List<SchoolEntity>list=Stream.of(new SchoolEntity(1,"narayana"),
				new SchoolEntity(2,"chaitanya"),
				new SchoolEntity(3,"primas"),
				new SchoolEntity(4,"new horizon"))
				.collect(Collectors.toList());
		
		schoolRepository.saveAll(list);
				
	}

}
