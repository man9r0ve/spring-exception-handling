package com.mangrove.springexceptionhandling.controller;

import com.mangrove.springexceptionhandling.dto.StudentDto;
import com.mangrove.springexceptionhandling.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;
	@PostMapping
	public StudentDto create(@RequestBody @Valid StudentDto studentDto) {
		log.trace("Create student {}", studentDto);
		return studentService.create(studentDto);
	}

	@GetMapping("/{id}")
	public StudentDto get(@PathVariable Long id) {
		log.trace("Find student by id {}", id);
		return studentService.getOne(id);
	}

}
