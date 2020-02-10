package com.patrickhub.oauthserverwithjwt.domain.dto;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class MyGrantedAuthority implements GrantedAuthority, Serializable {

	private String name;

	public MyGrantedAuthority(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return name;
	}
}
