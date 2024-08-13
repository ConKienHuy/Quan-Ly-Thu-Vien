package com.sgu.spring.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
}
