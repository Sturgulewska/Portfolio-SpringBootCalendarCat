package com.example.calenderCat;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CalenderCatApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = new SpringApplicationBuilder(CalenderCatApplication.class)
				.headless(false)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}
}
