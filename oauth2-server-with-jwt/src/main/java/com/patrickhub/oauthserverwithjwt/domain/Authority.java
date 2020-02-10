package com.patrickhub.oauthserverwithjwt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="authority", uniqueConstraints = @UniqueConstraint(columnNames = {"authorityName"}, name="UNIQUE_AUTHORITY_NAME_CONSTRAINT"))
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authorityID", columnDefinition = "bigint unsigned")
	private Integer id;

	@Column(length=20)
	private String authorityName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	
}
