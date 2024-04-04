package com.Java.Guides.khanhquanxanh;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.Java.Guides.khanhquanxanh.model.ApplicationUser;
import com.Java.Guides.khanhquanxanh.model.Role;
import com.Java.Guides.khanhquanxanh.reponsitory.RoleRepository;
import com.Java.Guides.khanhquanxanh.reponsitory.UserRepository;

@SpringBootApplication
public class KhanhquanxanhApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhanhquanxanhApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncode){
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser("admin", passwordEncode.encode("password"), roles);

			userRepository.save(admin);
		};
	}

}
