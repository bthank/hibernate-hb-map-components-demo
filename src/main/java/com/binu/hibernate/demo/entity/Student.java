package com.binu.hibernate.demo.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;  // javax.persistence are the JPA annotations
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	@Embedded  // this is an optional annotation since Hibernate can figure out this will be embedded based on @Ebmeddable annotation in Address class file
	@AttributeOverrides({
        @AttributeOverride(name="street", 
                           column=@Column(name="home_street")),
        @AttributeOverride(name="city", 
                           column=@Column(name="home_city")),
        @AttributeOverride(name="zipcode", 
        				   column=@Column(name="home_zipcode"))
	})
	private Address homeAddress;

	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="street", 
                           column=@Column(name="billing_street")),
        @AttributeOverride(name="city", 
                           column=@Column(name="billing_city")),
        @AttributeOverride(name="zipcode", 
        				   column=@Column(name="billing_zipcode"))
	})
	private Address billingAddress;
	
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}



	

	
	
	
	
}
