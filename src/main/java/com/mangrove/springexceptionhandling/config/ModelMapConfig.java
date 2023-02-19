package com.mangrove.springexceptionhandling.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapConfig {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
