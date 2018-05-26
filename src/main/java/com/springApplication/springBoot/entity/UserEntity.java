package com.springApplication.springBoot.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user_registration")
public class UserEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;
	
	@Column(name  ="email_address")
	private String emailAddress;
	@Column(name ="first_name")
	private String firstName;
	@Column(name ="last_name")
	private String lastName;
	
	@Column(name = "password")
	private String password;
	
	@OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
	private Idenitification idenitification;
	
	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
	private List<Address> address;
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Idenitification getIdenitification() {
		return idenitification;
	}

	public void setIdenitification(Idenitification idenitification) {
		this.idenitification = idenitification;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
