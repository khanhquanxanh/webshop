package com.Java.Guides.khanhquanxanh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.Java.Guides.khanhquanxanh.model.ApplicationUser;

import com.Java.Guides.khanhquanxanh.service.AuthenticationService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Controller

public class viewController {

	@Autowired
	AuthenticationService authenticationService;
	
	@GetMapping("/")
	public String Home() {
		return "index";
	}
	
	@GetMapping("/home")
	public String Home1(HttpServletRequest request, Model model) {
		Cookie[] cookies = request.getCookies();
        String jwtToken = null;
        if (cookies != null) {
        	System.out.println("cook khac null");
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("jwtToken")) {
                    jwtToken = cookie.getValue();
                    System.out.println(jwtToken);
                    model.addAttribute("jwtToken", jwtToken);
                    break;
                }
            }
        } else {
        	System.out.println("ban chua dang nhap");
    		model.addAttribute("jwtToken", "chua dang nhap");
        }
        
		return "index";
	}
	
	@GetMapping("index.html")
    public String index() {
        return "index";
    }
	
	@GetMapping("/login")
	public String login1() {
		return "login";
	}
	
//	@GetMapping("/about.html")
//	public String about() {
//		return "about";
//	}
	
	@GetMapping("/about.html")
	public String about() {
		return "about";
	} 
	
	@GetMapping("/login.html")
	public String login(Model model) {
		return "login";
	}

	
//	@PostMapping("/login.html")
//    public String login(@RequestParam String userName, @RequestParam String passWord, Model model) {
//        // Xử lý xác thực và kiểm tra đăng nhập
//        if (authenticationService.authenticate(userName, passWord)) {
//            // Xác thực thành công
//            model.addAttribute("userName", userName);
//            return "success";
//        } else {
//            // Xác thực thất bại
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//    }
	@GetMapping("/signUp.html")
	public String signUp(Model model) {
		model.addAttribute("account", new ApplicationUser());
		return "signUp";
	}
	
//	@PostMapping("/addAccount")
//    public String addUser(Account account) {
//    	accountRepository.save(account);
//        return "redirect:/signUp.html";
//    }

}
