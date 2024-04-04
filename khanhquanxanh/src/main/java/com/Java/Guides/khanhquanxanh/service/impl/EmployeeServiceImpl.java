//package com.Java.Guides.khanhquanxanh.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.Java.Guides.khanhquanxanh.exceprion.NotFoundException;
//
//import com.Java.Guides.khanhquanxanh.model.Employee;
//import com.Java.Guides.khanhquanxanh.reponsitory.EmployeeReponsitory;
//import com.Java.Guides.khanhquanxanh.service.EmployeeService;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService{
//	
////	private EmployeeReponsitory employeeReponsitory;
////	
////	@Autowired
////	public EmployeeServiceImpl(EmployeeReponsitory employeeReponsitory) {
////		super();
////		this.employeeReponsitory = employeeReponsitory;
////	}
////
////
////
////	@Override
////	public Employee saveEmployee(Employee employee) {
////		// TODO Auto-generated method stub
////		return employeeReponsitory.save(employee);
////	}
////
////
////
////	@Override
////	public List<Employee> getAllEmployee() {
////		// TODO Auto-generated method stub
////		return employeeReponsitory.findAll();
////	}
////
////
////
////	@Override
////	public Employee getById(long id) {
////        return employeeReponsitory.findById(id)
////                .orElseThrow(() -> new NotFoundException("id: " + id + "khong ton tai"));
////    }
////
////
////
////	@Override
////	public Employee updateEmployee(Employee employee, long id) {
////		Employee check = employeeReponsitory.findById(id).orElseThrow(() -> new NotFoundException("id: " + id + "khong ton tai"));
////		
////		check.setEmail(employee.getEmail());
////		check.setFirstName(employee.getFirstName());
////		check.setLastName(employee.getLastName());
////		
////		System.out.println("Saved/Updated Employee ID: " + id);
////		return employeeReponsitory.save(check);
////	}
////
////
////
////	@Override
////	public void deleteEmployee(long id) {
////		// TODO Auto-generated method stub
////		employeeReponsitory.findById(id).orElseThrow(() -> new NotFoundException("id: " + id + "khong ton tai"));
////		employeeReponsitory.deleteById(id);
////		
////	}
//	
//
//}
