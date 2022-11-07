package com.nttdata.bootcamp.msbankcredit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsBankCreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBankCreditApplication.class, args);
	}

}
