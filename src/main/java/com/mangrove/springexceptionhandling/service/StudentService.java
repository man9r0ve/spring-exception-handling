package com.mangrove.springexceptionhandling.service;

import com.mangrove.springexceptionhandling.domain.Student;
import com.mangrove.springexceptionhandling.dto.StudentDto;
import com.mangrove.springexceptionhandling.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository repository;
	private final ModelMapper mapper;

	public StudentDto create(StudentDto dto) {
		Student result = repository.save(mapper.map(dto, Student.class));
		return mapper.map(result, StudentDto.class);
	}
}
