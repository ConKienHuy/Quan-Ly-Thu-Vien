package com.sgu.spring.entity;

import java.util.Date;
import java.util.List;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull(message = "*Vui lòng nhập tên thể loại")
	@NotBlank(message = "*Vui lòng nhập tên thể loại")
	@Column(name = "name")
	private String name;
	
	@NotNull(message = "*Vui lòng nhập tên ngắn")
	@NotBlank(message = "*Vui lòng nhập tên ngắn")
	@Length(max = 4, message = "*Không được vượt quá 4 ký tự")
	@Column(name = "short_name")
	private String shortName;
	
	@Column(name = "notes")
	@Length(max = 1000, message = "*Không được vượt quá 1000 ký tự.")
	private String notes;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Book> books;
	
}
