package com.javasampleapproach.cassandra.dto;

import java.util.UUID;

import org.joda.time.DateTime;

public class SalesDTO {
	private UUID product_id;
	private UUID location_id;
	private UUID time_id;
	private int dollars;
	private DateTime created_at;
	private DateTime modified_at;

	public SalesDTO() {
	}

	public SalesDTO(UUID product_id, UUID location_id, UUID time_id, int dollars, DateTime created_at,
			DateTime modified_at) {
		super();
		this.product_id = product_id;
		this.location_id = location_id;
		this.time_id = time_id;
		this.dollars = dollars;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}

	public UUID getProduct_id() {
		return product_id;
	}

	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
	}

	public UUID getLocation_id() {
		return location_id;
	}

	public void setLocation_id(UUID location_id) {
		this.location_id = location_id;
	}

	public UUID getTime_id() {
		return time_id;
	}

	public void setTime_id(UUID time_id) {
		this.time_id = time_id;
	}

	public int getDollars() {
		return dollars;
	}

	public void setDollars(int dollars) {
		this.dollars = dollars;
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
