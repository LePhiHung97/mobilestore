package com.phihung.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.phihung.validator.DangKiValidator;
import com.phihung.validator.DangNhapValidator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.phihung")
@EnableTransactionManagement
@PropertySource(value="classpath:application.properties")
public class SpringConfig {

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resource/**").addResourceLocations("/resources/*");
	}

	// Messages properties config
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:messages");
		bundleMessageSource.setDefaultEncoding("utf-8");
		return bundleMessageSource;
	}

	// validator
	@Bean DangKiValidator dangKiValidator() {
		return new DangKiValidator();
	}
	
	@Bean DangNhapValidator dangNhapValidator() {
		return new DangNhapValidator();
	}
}
