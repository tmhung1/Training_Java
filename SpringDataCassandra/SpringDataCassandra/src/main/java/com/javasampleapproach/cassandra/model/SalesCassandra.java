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

@Table(value = "sales")
public class SalesCassandra implements Serializable {

	private static final long serialVersionUID = -4071974845577358677L;

	private UUID product_id;

	private UUID location_id;

	private UUID time_id;

	private int dollars;

	@Column("created_at")
	private DateTime createdAt;

	@Column("modified_at")
	private DateTime modifiedAt;

	public SalesCassandra() {
	}
	
	public SalesCassandra(UUID product_id, UUID location_id, UUID time_id, int dollars, DateTime createdAt,
			DateTime modifiedAt) {
		super();
		this.product_id = product_id;
		this.location_id = location_id;
		this.time_id = time_id;
		this.dollars = dollars;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}



	@PrimaryKeyColumn(name = "product_id",type=PrimaryKeyType.PARTITIONED,ordinal=1)
	@CassandraType(type = Name.UUID)
	public UUID getProduct_id() {
		return product_id;
	}

	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
	}

	@PrimaryKeyColumn(name = "location_id",type=PrimaryKeyType.PARTITIONED,ordinal=2)
	@CassandraType(type = Name.UUID)
	public UUID getLocation_id() {
		return location_id;
	}

	public void setLocation_id(UUID location_id) {
		this.location_id = location_id;
	}

	@PrimaryKeyColumn(name = "time_id",type=PrimaryKeyType.PARTITIONED,ordinal=3)
	@CassandraType(type = Name.UUID)
	public UUID getTime_id() {
		return time_id;
	}

	public void setTime_id(UUID time_id) {
		this.time_id = time_id;
	}

	@Column("dollars")
	public int getDollars() {
		return dollars;
	}

	public void setDollars(int dollars) {
		this.dollars = dollars;
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
