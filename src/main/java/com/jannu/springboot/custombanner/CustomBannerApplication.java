package com.jannu.springboot.custombanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomBannerApplication {

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(CustomBannerApplication.class);
		application.setBanner(new CustomBanner());
		application.run(args);
//		SpringApplication.run(CustomBannerApplication.class, args);
	}

}
