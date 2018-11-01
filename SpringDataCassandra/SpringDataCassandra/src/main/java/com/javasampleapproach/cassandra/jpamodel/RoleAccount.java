package com.javasampleapproach.cassandra.jpamodel;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roleaccount")
public class RoleAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private UUID id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private Set<UserAccount> users;

	public Set<UserAccount> getUsers() {
		return users;
	}
	public void setUsers(Set<UserAccount> users) {
		this.users = users;
	}
	public RoleAccount(UUID id,String name) {
		super();
		
		this.name = name;
		this.id=id;
	}
	public RoleAccount(){}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
