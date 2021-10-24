package com.project.busybeeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.project.persistence_layer.repository")
@EntityScan("com.project.business_layer.entity")
@SpringBootApplication(scanBasePackages = "com.project")
public class BusybeeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusybeeServerApplication.class, args);
	}

}
