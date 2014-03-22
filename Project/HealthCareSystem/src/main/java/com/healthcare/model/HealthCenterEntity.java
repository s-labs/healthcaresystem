package com.healthcare.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "healthcenter")
public class HealthCenterEntity {
	

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column
	private String name;
	
	@Column
	private int level;
	
	@OneToOne(fetch = FetchType.EAGER)	
	@JoinColumn(name = "next")
	@IndexColumn(name="id")
	private HealthCenterEntity next;
	
	@OneToMany(fetch = FetchType.EAGER)	
	@JoinColumn(name = "healthcentercode")
	@IndexColumn(name="USER_ID")
	private Set<UserEntity> users;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public HealthCenterEntity getNext() {
		return next;
	}

	public void setNext(HealthCenterEntity next) {
		this.next = next;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}




}
