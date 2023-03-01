package com.Intuit.socialNewsFeed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({  "com.Intuit.socialNewsFeed.model",
		"com.Intuit.socialNewsFeed.service" })
public class SocialNewsFeedApplication {
	private static final Logger logger = LoggerFactory.getLogger(SocialNewsFeedApplication.class);

	public static void main(String[] args) {
		logger.info("start");
		SpringApplication.run(SocialNewsFeedApplication.class, args);
	}
}
