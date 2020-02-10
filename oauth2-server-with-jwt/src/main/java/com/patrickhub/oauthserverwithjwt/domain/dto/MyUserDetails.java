package com.patrickhub.oauthserverwithjwt.domain.dto;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails{

	
	private String username;

	private String password;

	private Set<GrantedAuthority> grantedAuthorities;

	public MyUserDetails() {

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<GrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}

	public void setGrantedAuthorities(Set<GrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
