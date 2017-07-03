package com.parkoon.security;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.parkoon.security.domain.Account;
import com.parkoon.security.repository.AccountRepository;

@SpringBootApplication
public class SpringBootSecurityApplication {

	@Autowired
	AccountRepository accountRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}
	
	@Bean
	InitializingBean insertFixtureUsers() {
		return () -> {
			Account admin = new Account();
			admin.setUserId("admin");
			admin.setPassword("1234");
			admin.setRole("ROLE_ADMIN");
			admin.setNick("관리자");
			accountRepository.save(admin);
			
			Account user = new Account();
			user.setUserId("user");
			user.setPassword("1234");
			user.setRole("ROLE_USER");
			user.setNick("일반유저");
			accountRepository.save(user);
		};
	}
}
