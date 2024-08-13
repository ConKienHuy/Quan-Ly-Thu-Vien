package com.sgu.spring.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "member")
public class Member implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@NotEmpty(message = "*Vui lòng nhập loại member")
	@NotNull(message = "*Vui lòng nhập loại member")
	@Column(name = "type")
	private String type;
	
	@NotEmpty(message = "*Vui lòng nhập tên")
	@NotNull(message = "*Vui lòng nhập tên")
	@Column(name = "first_name")
	private String firstName;
	
	@NotEmpty(message = "*Vui lòng nhập tên lót")
	@NotNull(message = "*Vui lòng nhập tên lót")
	@Column(name = "middle_name")
	private String middleName;
	
	@NotEmpty(message = "*Vui lòng nhập tên đệm")
	@NotNull(message = "*Vui lòng nhập tên đệm")
	@Column(name = "last_name")
	private String lastName;
	
	@NotEmpty(message = "*Vui lòng chọn giới tính")
	@NotNull(message = "*Vui lòng chọn giới tính")
	@Column(name = "gender")
	private String gender;
	
	@NotNull(message = "*Vui lòng nhập ngày sinh")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "joining_date")
	private Date joiningDate;
	
	@Column(name = "contact")
	private String contact;
	
	@Column(name = "email")
	private String email;
	
	public Member(@NotNull String type, @NotNull String firstName, @NotNull String middleName, @NotNull String lastName,
			@NotNull String gender, @NotNull Date dateOfBirth, @NotNull Date joiningDate) {
		this.type = type;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.joiningDate = joiningDate;
	}
	
	public Member() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
