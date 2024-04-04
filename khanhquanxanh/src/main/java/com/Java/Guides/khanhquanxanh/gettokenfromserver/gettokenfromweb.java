package com.Java.Guides.khanhquanxanh.gettokenfromserver;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class gettokenfromweb {
	public static void gettoken() {
		// Tạo RestTemplate instance
	    RestTemplate restTemplate = new RestTemplate();

	    // URL của endpoint cần truy cập
	    String url = "http://example.com/api/resource";

	    // Mã token JWT của người dùng
	    String jwtToken = "your_jwt_token_here";

	    // Tạo header chứa mã token
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Authorization", "Bearer " + jwtToken);

	    // Gửi yêu cầu GET đến endpoint /api/resource với mã token trong header Authorization
	    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

	    // Xử lý phản hồi từ server
	    String responseBody = response.getBody();
	    System.out.println(responseBody);
	}
	
}
