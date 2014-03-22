package com.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRolesEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long USER_ROLE_ID;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usercode", nullable = false)
	UserEntity user;
	
	@Column
	String authority;

	public UserRolesEntity() {
		
	}
	public UserRolesEntity(String authority) {
		this.authority = authority;

	}

	public long getUSER_ROLE_ID() {
		return USER_ROLE_ID;
	}

	public void setUSER_ROLE_ID(long uSER_ROLE_ID) {
		USER_ROLE_ID = uSER_ROLE_ID;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
