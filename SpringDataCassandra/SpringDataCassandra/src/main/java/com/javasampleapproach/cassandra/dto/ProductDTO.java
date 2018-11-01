package com.javasampleapproach.cassandra.dto;

import java.sql.Timestamp;
import java.util.UUID;

import org.joda.time.DateTime;

public class ProductDTO {
	private UUID product_id;
	private int item;
	private String pclass;
	private String inventory;
	private DateTime created_at;
	private DateTime modified_at;

	public ProductDTO() {
	}

	public ProductDTO(UUID product_id, int item, String pclass, String inventory, DateTime created_at,
			DateTime modified_at) {
		super();
		this.product_id = product_id;
		this.item = item;
		this.pclass = pclass;
		this.inventory = inventory;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}
	public ProductDTO(int item, String pclass, String inventory, DateTime created_at,
			DateTime modified_at) {
		super();
		
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
