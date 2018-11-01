package com.javasampleapproach.cassandra.jpamodel;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="location")
public class Location {
	@Id
	@GeneratedValue
	@Column(name="location_id",unique=true,nullable=false)
	private UUID location_id;
	
	@Column(name="country",nullable=false)
	private String country;
	
	@Column(name="city",nullable=false)
	private String city;
	
	@Column(name="created_at",nullable=false)
	private Timestamp created_at;
	
	@Column(name="modified_at",nullable=false)
	private Timestamp modified_at;
	
	public Location(){}
	
	public Location(UUID location_id, String country, String city, Timestamp created_at, Timestamp modified_at) {
		super();
		this.location_id = location_id;
		this.country = country;
		this.city = city;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}

	public UUID getLocation_id() {
		return location_id;
	}

	public void setLocation_id(UUID location_id) {
		this.location_id = location_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getModified_at() {
		return modified_at;
	}

	public void setModified_at(Timestamp modified_at) {
		this.modified_at = modified_at;
	}
	
}
