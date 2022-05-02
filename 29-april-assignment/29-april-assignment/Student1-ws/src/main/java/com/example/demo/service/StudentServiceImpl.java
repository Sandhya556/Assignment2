package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.StudentEntity;
import com.example.demo.repo.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
	
	private final StudentRepository studentRepository;
	
	@Override
	public StudentEntity createStudent(StudentEntity studentEntity) {
		// TODO Auto-generated method stub
		return studentRepository.save(studentEntity);
	}
	

}
