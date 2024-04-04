package com.Java.Guides.khanhquanxanh.model;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements GrantedAuthority{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer roleId;
	
	private String authority;
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String authority) {
		this.authority = authority;
	}
	
	public Role(Integer roleId, String authority) {
		super();
		this.roleId = roleId;
		this.authority = authority;
	}


	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
