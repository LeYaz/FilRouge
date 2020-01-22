package com.example.ProjetFilRougeGarage;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


	 @Configuration
	 public class WebMvcConfig implements WebMvcConfigurer  {
		 @Bean(name = "messageSource")
		 public MessageSource getMessageResource() {
		  ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
		  messageResource.setBasename("classpath:i18n/messages");
	        messageResource.setDefaultEncoding("UTF-8");
	        System.out.println("messageSource");
	        return messageResource;
		 	}
	  }
