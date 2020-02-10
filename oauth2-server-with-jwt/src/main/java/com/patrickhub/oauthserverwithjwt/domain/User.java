package com.patrickhub.oauthserverwithjwt.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="users", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}, name="UNIQUE_USERNAME_CONSTRAINT"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID", columnDefinition = "bigint unsigned")
	private Integer id;

	@Column(length=50)
	private String username;

	@Column
	private String password;

	@Column
	private Boolean accountExpired;

	@Column
	private Boolean accountLocked;

	@Column
	private Boolean credentialsExpired;

	@Column
	private Boolean enabled;

	
	@OneToMany(mappedBy = "user", targetEntity = UserAuthority.class, cascade = {
			CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<UserAuthority> authorities = new HashSet<UserAuthority>();

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAccountExpired() {
		return accountExpired;
	}

	public void setAccountExpired(Boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public Boolean getAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(Boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public Boolean getCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(Boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserAuthority> getUserAuthorities() {
		return authorities;
	}

	public void setUserAuthorities(Set<UserAuthority> authorities) {
		this.authorities = authorities;
	}
	
	
}
