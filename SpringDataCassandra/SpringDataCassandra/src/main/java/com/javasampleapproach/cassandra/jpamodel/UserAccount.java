package com.javasampleapproach.cassandra.jpamodel;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="useraccount")
public class UserAccount {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private UUID id;
		
		@Column(name="email")
		private String email;
		
		@Column(name="password")
		private String password;

		@ManyToMany
		@JoinTable(name="user_role",joinColumns=@JoinColumn(name="user_id")
		,inverseJoinColumns=@JoinColumn(name="role_id"))
		private Set<RoleAccount> roles;
		public UserAccount(UUID id, String email, String password) {
			super();
			this.id = id;
			this.email = email;
			this.password = password;
		}
		public UserAccount(){}

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		public Set<RoleAccount> getRoles() {
			return roles;
		}
		public void setRoles(Set<RoleAccount> roles) {
			this.roles = roles;
		}
		
		
}
