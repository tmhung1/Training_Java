package com.javasampleapproach.cassandra.jpamodel;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class SalesId implements Serializable {
	
	
	private UUID product_id;
	
	
	private UUID location_id;
	
	
	private UUID time_id;
	
	public SalesId(){}

	@Column(name="product_id",nullable=false)
	public UUID getProduct_id() {
		return product_id;
	}

	public void setProduct_id(UUID product_id) {
		this.product_id = product_id;
	}

	@Column(name="location_id",nullable=false)
	public UUID getLocation_id() {
		return location_id;
	}

	public void setLocation_id(UUID location_id) {
		this.location_id = location_id;
	}

	@Column(name="time_id",nullable=false)
	public UUID getTime_id() {
		return time_id;
	}

	public void setTime_id(UUID time_id) {
		this.time_id = time_id;
	}
	//compare 2 object SalesID
		@Override
		public boolean equals(Object other) {
			if ((this == other))
				return true;
			if ((other == null))
				return false;
			if (!(other instanceof SalesId))
				return false;
			SalesId castOther = (SalesId) other;

			return (this.getProduct_id() == castOther.getProduct_id()) && (this.getTime_id() == castOther.getTime_id())
					&& (this.getLocation_id()) == castOther.getLocation_id();
		}

		@Override
		public int hashCode() {
			int result = 17;

			result = 37 * result + this.getProduct_id().hashCode();
			result = 37 * result + this.getTime_id().hashCode();
			result = 37 * result + this.getLocation_id().hashCode();
			return result;
		}
}
