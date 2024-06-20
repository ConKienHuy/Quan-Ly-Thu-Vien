package com.sgu.spring.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "display_name")
	private String displayName;
	
	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "active")
	private Integer active;
	
	@NotNull
	@Column(name = "role")
	private String role;
	
	@NotNull
	@Column(name = "created_date")
	private String createdDate;
	
	@NotNull
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	
	public User() {	}
	
	public User(@NotNull String displayName, @NotNull String username, @NotNull String password,
			@NotNull @NotNull Integer active, @NotNull String role, @NotNull String createdDate, @NotNull Date lastModifiedDate) {
		this.displayName = displayName;
		this.username = username;
		this.password = password;
		this.active = active;
		this.role = role;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public @NotNull Integer getActive() {
		return active;
	}

	public void setActive(@NotNull Integer active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
}
