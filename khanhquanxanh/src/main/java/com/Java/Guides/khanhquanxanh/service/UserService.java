package com.Java.Guides.khanhquanxanh.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Java.Guides.khanhquanxanh.model.ApplicationUser;
import com.Java.Guides.khanhquanxanh.model.CustomUserDetails;
import com.Java.Guides.khanhquanxanh.model.Role;
import com.Java.Guides.khanhquanxanh.reponsitory.RoleRepository;
import com.Java.Guides.khanhquanxanh.reponsitory.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("In the user details service");
        System.out.println(username);
        System.out.println(userRepository.findByUsername(username).get().getPassword());
//        ApplicationUser user = userRepository.findByUsername(username);
//        if(user==null){
//            throw new UsernameNotFoundException("User not exists by Username");
//           }
//        //Role adminRole = roleRepository.save(new Role("ADMIN"));
//		Role userRole = roleRepository.save(new Role("USER"));
//
//		Set<Role> roles = new HashSet<>();
//		roles.add(userRole);
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
//        return new CustomUserDetails(user);
    }
	

}
