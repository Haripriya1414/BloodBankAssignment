package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name="donor")
public class Donor {
	@Id
	@Column(name="donorid")
	int donorId;
	@Column(name="donorname")
	String donorName;
	@Column(name="bloodgroup")
	String bloodGroup;
	@Column(name="age")
	int age;
	@Column(name="location")
	String location;
	@Column(name="phonenumber")
	long phoneNumber;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name="lastdonation")
	LocalDate lastDonation;
	@Column(name="pincode")
	int pincode;

}
