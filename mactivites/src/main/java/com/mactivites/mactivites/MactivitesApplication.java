package com.mactivites.mactivites;

import com.mactivites.mactivites.dao.ProjetRepository;
import com.mactivites.mactivites.entities.Projet;
import com.mactivites.mactivites.services.AppInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EnableDiscoveryClient
public class MactivitesApplication implements CommandLineRunner {

	@Autowired
	private AppInitService appInitService;

	public static void main(String[] args) {
		SpringApplication.run(MactivitesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		appInitService.initProjets();
		appInitService.initEmployes();
		appInitService.initRoles();
	}
}
