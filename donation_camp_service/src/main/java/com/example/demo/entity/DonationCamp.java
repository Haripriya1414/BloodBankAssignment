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
@Table(name="donation_camp")
public class DonationCamp {
	
	@Id
	@Column(name="campid")
	int campId;
	@Column(name="campname")
	String campName;
	@Column(name="camplocation")
	String campLocation;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name="campdate")
	LocalDate campDate;
	@Column(name = "campphonenumber")
	long campPhoneNumber;
	@Column(name="camppincode")
	int campPincode;
	
	

}
