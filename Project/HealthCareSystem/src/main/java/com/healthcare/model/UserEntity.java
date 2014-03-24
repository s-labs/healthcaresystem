package com.healthcare.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long USER_ID;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private boolean enabled;
	

	@OneToMany(fetch = FetchType.EAGER,cascade={CascadeType.ALL})
    @JoinColumn(name="usercode")
    @IndexColumn(name="USER_ROLE_ID")
	private Set<UserRolesEntity> roles = new HashSet<UserRolesEntity>(
			0);
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "healthcentercode",nullable = true)
	private HealthCenterEntity healthcenter;
	
	public long getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(long uSER_ID) {
		USER_ID = uSER_ID;
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
	public boolean isEnabled() {
		return true;
	}
	public void setEnabled(boolean enabled) {
		
		
		this.enabled = enabled;
	}
	public Set<UserRolesEntity> getRoles() {
		return roles;
	}
	public void setRoles(Set<UserRolesEntity> roles) {
		this.roles = roles;
	}
	public HealthCenterEntity getHealthcenter() {
		return healthcenter;
	}
	public void setHealthcenter(HealthCenterEntity healthcenter) {
		this.healthcenter = healthcenter;
	}
	
	
}
