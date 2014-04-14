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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "STATE")
public class StateEntity {

	
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	
	@Column(name = "name")
	private String name;
	

	@OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL})
    @JoinColumn(name="statecode")
    @IndexColumn(name="code")
	private Set<DistrictEntity> districts = new HashSet<DistrictEntity>(
			0);
	
	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DistrictEntity> getDistricts() {
		return districts;
	}

	public void setDistricts(Set<DistrictEntity> districts) {
		this.districts = districts;
	}
	
	

}
