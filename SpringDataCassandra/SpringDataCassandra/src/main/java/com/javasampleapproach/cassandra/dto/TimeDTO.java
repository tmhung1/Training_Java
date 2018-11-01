package com.javasampleapproach.cassandra.dto;

import java.util.UUID;

import org.joda.time.DateTime;

public class TimeDTO {
	private UUID time_id;
	private int month;
	private int quarter;
	private int year;
	private DateTime created_at;
	private DateTime modified_at;

	public TimeDTO() {
	}

	public TimeDTO(UUID time_id, int month, int quarter, int year, DateTime created_at, DateTime modified_at) {
		super();
		this.time_id = time_id;
		this.month = month;
		this.quarter = quarter;
		this.year = year;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}

	public UUID getTime_id() {
		return time_id;
	}

	public void setTime_id(UUID time_id) {
		this.time_id = time_id;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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
