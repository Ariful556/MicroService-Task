package com.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OnlineBookLibraryApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(OnlineBookLibraryApplication.class, args);
	}

}
