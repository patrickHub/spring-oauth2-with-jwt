package com.patrickhub.oauthserverwithjwt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_refresh_token")
public class Oauth_Refresh_Token {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oauthRefrehTokenID", columnDefinition = "bigint unsigned")
	private Integer id;
	
	@Column(name="tokenID")
	private String tokenId;
	
	@Lob
	@Column(name="token", columnDefinition = "mediumblob")
	private byte[] token;
	
	@Lob
	@Column(name="authentication", columnDefinition = "mediumblob")
	private byte[] authentication;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public byte[] getToken() {
		return token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}
	
	
}
