package com.jpa_stream;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(scanBasePackages={"com.speedment.jpastreamer"})
@SpringBootApplication()
public class JpaStreamApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaStreamApplication.class, args);
	}

}
