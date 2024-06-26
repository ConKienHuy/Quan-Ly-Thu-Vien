package com.sgu.spring.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "book")
public class Book implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotNull(message = "*Vui lòng nhập tên sách")
	@NotBlank(message = "*Vui lòng nhập tên sách")
	@Column(name = "title")
	private String title;
	
	@NotNull(message = "*Vui lòng nhập tag")
	@NotBlank(message = "*Vui lòng nhập tag")
	@Column(name = "tag")
	private String tag;
	
	@NotNull(message = "*Vui lòng nhập tên tác giả")
	@NotBlank(message = "*Vui lòng nhập tên tác giả")
	@Column(name = "authors")
	private String authors;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	@NotNull(message = "Please select category")
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
