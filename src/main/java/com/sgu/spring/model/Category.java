package com.sgu.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotNull(message = "*Vui lòng nhập tên thể loại")
	@NotBlank(message = "*Vui lòng nhập tên thể loại")
	@Column(name = "name")
	private String name;
	
	@NotNull(message = "*Please enter category short name")
	@NotBlank(message = "*Please enter category short name")
	@Length(max = 4, message = "*Must not excedd 4 character")
	@Column(name = "short_name")
	private String shortName;
	
	@Column(name = "notes")
	@Length(max = 1000, message = "*Must not exceed 1000 characters.")
	private String notes;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Book> books;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getNotes() {
		return this.notes;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
