package com.mangrove.springexceptionhandling.controller;

import com.mangrove.springexceptionhandling.dto.StudentDto;
import com.mangrove.springexceptionhandling.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
