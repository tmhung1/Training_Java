package com.javasampleapproach.cassandra.model;

import com.datastax.driver.core.DataType.Name;

import java.io.Serializable;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "time")
public class TimeCassandra implements Serializable {


	private static final long serialVersionUID = 336048348883899929L;

	private UUID time_id;

	@Column(value = "month")
	private int month;

	@Column(value = "quarter")
	private int quarter;

	@Column(value = "year")
	private int year;

	@Column("created_at")
	private DateTime createdAt;
	
	@Column("modified_at")
	private DateTime modifiedAt;

	public TimeCassandra() {
	}
	
	public TimeCassandra(UUID time_id, int month, int quarter, int year, DateTime createdAt, DateTime modifiedAt) {
		super();
		this.time_id = time_id;
		this.month = month;
		this.quarter = quarter;
		this.year = year;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	@PrimaryKeyColumn(name = "time_id",type=PrimaryKeyType.PARTITIONED,ordinal=1)
	@CassandraType(type = Name.UUID)
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

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public DateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(DateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
