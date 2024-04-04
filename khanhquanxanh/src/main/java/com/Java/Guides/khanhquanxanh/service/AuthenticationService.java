package com.Java.Guides.khanhquanxanh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.Java.Guides.khanhquanxanh.model.ApplicationUser;
import com.Java.Guides.khanhquanxanh.model.LoginResponseDTO;
import com.Java.Guides.khanhquanxanh.model.Role;

import com.Java.Guides.khanhquanxanh.reponsitory.RoleRepository;
import com.Java.Guides.khanhquanxanh.reponsitory.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationService {

//    private final AccountRepository accountRepository;
//
//    @Autowired
//    public AuthenticationService(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }
//
//    public boolean authenticate(String userName, String passWord) {
//        Optional<Account> accountOptional = accountRepository.findByUserName(userName);
//        return accountOptional.map(account -> account.getPassWord().equals(passWord)).orElse(false);
//    }
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public ApplicationUser RegisterUser(ApplicationUser account) {
		
		System.out.println(account.getPassword());
		String encoderPassword = passwordEncoder.encode(account.getPassword());
		System.out.println(encoderPassword);
		account.setPassword(encoderPassword);
		Role userRole = roleRepository.findByAuthority("ADMIN").get();
		Set<Role> authorities = new HashSet<>();
		authorities.add(userRole);
		account.setAuthorities(authorities);
		System.out.println("luu thanh cong");
		return userRepository.save(account);
//		return userRepository.save(new ApplicationUser(account.getUsername(),encoderPassword, authorities));
	}
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService; 
    
	public LoginResponseDTO loginUser(String username, String password){

        try{
        	System.out.println(username);
        	System.out.println(password);
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);
            
            System.out.println("xac thuc thanh cong va token tra ve: " + token);

            return new LoginResponseDTO(userRepository.findByUsername(username).get(), token);

        } catch(AuthenticationException e){
        	System.out.println("bi dinh ngoai le roi");
            return new LoginResponseDTO(null, "");
        }
    }
	

	
}