package com.Java.Guides.khanhquanxanh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Java.Guides.khanhquanxanh.model.JwtResponse;


//import com.Java.Guides.khanhquanxanh.model.Employee;
//import com.Java.Guides.khanhquanxanh.service.EmployeeService;

@RestController
public class EmployeeController {
	
//	private EmployeeService employeeService;
//	
//	@Autowired
//	public EmployeeController(EmployeeService employeeService) {
//		super();
//		this.employeeService = employeeService;	
//	}
//	@PostMapping("/saveE")
//	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
//		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
//	}
//	@GetMapping("/getE")
//	public List<Employee> getAllEntity(){
//		return employeeService.getAllEmployee();
//	}
//	@PostMapping("/saveEe")
//	public Employee saveEmployee1(@RequestBody Employee employee) {
//	    return employeeService.saveEmployee(employee);
//	}
//	@GetMapping("/getId/{id}")
//	public ResponseEntity<Employee> getById(@PathVariable("id") long id) {
//		return new ResponseEntity<Employee>(employeeService.getById(id), HttpStatus.CREATED);
//	}
//	
//	@PutMapping("/update/{id}")
//	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
//		 return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.CREATED);
//	}
//	
//	@DeleteMapping("/del/{id}")
//	public ResponseEntity<?> deleteEmployee(@PathVariable long id){
//		employeeService.deleteEmployee(id);
//		return new ResponseEntity<String>("Delete sucess", HttpStatus.OK);
//	}
	private JwtResponse value;
	@GetMapping("/about")
    public String getResource() {
        // Tạo RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();
	    // URL của endpoint cần truy cập
	    String apiUrl = "http://localhost:8686/about.html";

	    // Mã token JWT của người dùng
	    String jwtToken = value.getToken();

        // Tạo header chứa mã token
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwtToken);

        // Gửi yêu cầu GET đến endpoint được chỉ định với mã token trong header Authorization
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        // Xử lý phản hồi từ server
        String responseBody = response.getBody();
        return responseBody;
    }
	
	
}
