package com.mrKhoai.webshop.beta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.mrKhoai.webshop")
@EntityScan(basePackages = "com.mrKhoai.webshop.objects")
@EnableJpaRepositories(basePackages = "com.mrKhoai.webshop.repositories")
public class BetaApplication {

	public static void main(String[] args) {
		//test commit bao 
		SpringApplication.run(BetaApplication.class, args);
	}
}
