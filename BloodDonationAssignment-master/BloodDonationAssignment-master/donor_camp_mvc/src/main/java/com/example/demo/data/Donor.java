package com.example.demo.data;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Donor {
	//@NotNull(message="Enter Donor Id")
	@Min(value=100, message="ID must be equal or greater than 18")
	@Max(value=10000, message="ID must be equal or less than 10,000")
	int donorId;
	@NotEmpty(message="Enter Donor Name")
	String donorName;
	@NotEmpty(message="Enter Donor Blood Group")
	String bloodGroup;
	@NotNull(message="Enter Donor Age")
	@Min(value=18, message="Age must be equal or greater than 18")
	@Max(value=60, message="Age must be equal or less than 60")
	int age;
	String location;
	//@NotNull(message="Enter Donor Phone Number")
	long phoneNumber;
	@NotNull(message="Enter Donor Last Donation date")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate lastDonation;
	//@NotNull(message="Enter Donor Pincode")
	int pincode;
	
}
