package com.javasampleapproach.cassandra.jpamodel;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="time")
public class Time {
	@Id
	@GeneratedValue
	@Column(name="time_id",unique=true,nullable=false)
	private UUID time_id;
	
	@Column(name="month",nullable=false)
	private int month;
	
	@Column(name="quarter",nullable=false)
	private int quarter;
	
	@Column(name="year",nullable=false)
	private int year;
	
	@Column(name="created_at",nullable=false)
	private Timestamp created_at;
	
	@Column(name="modified_at",nullable=false)
	private Timestamp modified_at;
	
	public Time(){}
	
	public Time(UUID time_id, int month, int quarter, int year, Timestamp created_at, Timestamp modified_at) {
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
