package com.javasampleapproach.cassandra.jpamodel;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sales {
	private SalesId id;
	private Product product;
	private Location location;
	private Time time;
	private int dollars;
	private Timestamp created_at;
	private Timestamp modified_at;

	public Sales() {
	}

	public Sales(SalesId id, Product product, Location location, Time time, int dollars, Timestamp created_at,
			Timestamp modified_at) {
		super();
		this.id = id;
		this.product = product;
		this.location = location;
		this.time = time;
		this.dollars = dollars;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "productid", column = @Column(name = "product_id", nullable = false)),
			@AttributeOverride(name = "timeid", column = @Column(name = "time_id", nullable = false)),
			@AttributeOverride(name = "locationid", column = @Column(name = "location_id", nullable = false)) })
	public SalesId getId() {
		return id;
	}

	public void setId(SalesId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", insertable = false, updatable = false)
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "time_id", insertable = false, updatable = false)
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Column(name = "dollars", nullable = false)
	public int getDollars() {
		return dollars;
	}

	public void setDollars(int dollars) {
		this.dollars = dollars;
	}

	@Column(name = "created_at", nullable = false)
	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	@Column(name = "modified_at", nullable = false)
	public Timestamp getModified_at() {
		return modified_at;
	}

	public void setModified_at(Timestamp modified_at) {
		this.modified_at = modified_at;
	}

}
