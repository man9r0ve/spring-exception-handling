package com.mangrove.springexceptionhandling.service;

import com.mangrove.springexceptionhandling.domain.Student;
import com.mangrove.springexceptionhandling.dto.StudentDto;
import com.mangrove.springexceptionhandling.errors.Errors;
import com.mangrove.springexceptionhandling.exception.ApplicationException;
import com.mangrove.springexceptionhandling.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository repository;
	private final ModelMapper mapper;

	public StudentDto create(StudentDto dto) {
		Student result = repository.save(mapper.map(dto, Student.class));
		return mapper.map(result, StudentDto.class);
	}

	public StudentDto getOne(Long id) {
		return repository.findById(id)
				       .map((f) -> mapper.map(f, StudentDto.class))
				       .orElseThrow(() -> new ApplicationException(Errors.STUDENT_NOT_FOUND, Map.of("id", id)));
	}

}
