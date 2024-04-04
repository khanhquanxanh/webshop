package com.Java.Guides.khanhquanxanh.reponsitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Java.Guides.khanhquanxanh.model.ApplicationUser;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Integer>{
	Optional<ApplicationUser> findByUsername(String username);
//	ApplicationUser findByUsername(String username);
}
