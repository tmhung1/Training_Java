package com.javasampleapproach.cassandra.jpamodel;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "product_id",unique=true, nullable = false)
	private UUID product_id;

	@Column(name = "item", nullable = false)
	private int item;

	@Column(name = "[class]", nullable = false)
	private String pclass;

	@Column(name = "inventory", nullable = false)
	private String inventory;

	@Column(name = "created_at", nullable = false)
	private Timestamp created_at;

	@Column(name = "modified_at", nullable = false)
	private Timestamp modified_at;

	public Product() {
	}

	public Product(UUID product_id, int item, String pclass, String inventory, Timestamp created_at,
			Timestamp modified_at) {
		super();
		this.product_id = product_id;
		this.item = item;
		this.pclass = pclass;
		this.inventory = inventory;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}

	public UUID getProduct_id() {
		return product_id;
	}

	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getPclass() {
		return pclass;
	}

	public void setPclass(String pclass) {
		this.pclass = pclass;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
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
