package com.javasampleapproach.cassandra.dto;

import java.util.UUID;

import org.joda.time.DateTime;

public class LocationDTO {
	private UUID location_id;
	private String country;
	private String city;
	private DateTime created_at;
	private DateTime modified_at;

	public LocationDTO() {
	}

	public LocationDTO(UUID location_id, String country, String city, DateTime created_at, DateTime modified_at) {
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

	public DateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(DateTime created_at) {
		this.created_at = created_at;
	}

	public DateTime getModified_at() {
		return modified_at;
	}

	public void setModified_at(DateTime modified_at) {
		this.modified_at = modified_at;
	}

}
