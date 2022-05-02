package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "school-ws")
public interface SchoolProxy {
	@GetMapping("/school/{schoolName}")
	public SchoolDto getSchoolName(@PathVariable("schoolName")String schoolName);

}
