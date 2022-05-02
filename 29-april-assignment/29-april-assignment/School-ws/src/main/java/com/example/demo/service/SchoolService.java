package com.example.demo.service;

import java.util.List;

import com.example.demo.model.SchoolEntity;

public interface SchoolService {
	
	public SchoolEntity findASchoolByName(String schoolName);
	
	public List<SchoolEntity> getAll();

}
