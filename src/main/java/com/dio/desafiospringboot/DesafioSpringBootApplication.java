package com.dio.desafiospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioSpringBootApplication.class, args);
	}

}
