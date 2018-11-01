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

@Table(value = "location")
public class LocationCassandra implements Serializable {

	private static final long serialVersionUID = 5908943625382686609L;

	private UUID location_id;

	@Column(value = "country")
	private String country;

	@Column(value = "city")
	private String city;

	@Column("created_at")
	private DateTime createdAt;
	
	@Column("modified_at")
	private DateTime modifiedAt;

	public LocationCassandra() {
	}

	
	
	public LocationCassandra(UUID location_id, String country, String city, DateTime createdAt, DateTime modifiedAt) {
		super();
		this.location_id = location_id;
		this.country = country;
		this.city = city;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}



	@PrimaryKeyColumn(name = "location_id",type=PrimaryKeyType.PARTITIONED,ordinal=1)
	@CassandraType(type = Name.UUID)
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
