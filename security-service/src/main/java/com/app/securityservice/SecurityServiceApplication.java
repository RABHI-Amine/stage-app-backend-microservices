package com.app.securityservice;

import com.app.securityservice.entities.AppRole;
import com.app.securityservice.entities.AppUser;
import com.app.securityservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class SecurityServiceApplication implements CommandLineRunner {

	@Autowired
	private AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(SecurityServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.saveRole(new AppRole(null,"USER"));
		accountService.saveRole(new AppRole(null,"ADMIN"));

		Stream.of("user1","user2","user3").forEach(un -> {
			accountService.saveUser(un,"1234","1234");
		});

		accountService.saveUser("admin","1234","1234");
		accountService.addRoleToUser("admin","ADMIN ");
	}

	@Bean
	BCryptPasswordEncoder getBCE(){
		return new BCryptPasswordEncoder();
	}
}
