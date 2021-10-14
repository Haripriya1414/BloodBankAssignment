package com.example.demo.data;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Camp {
	
	@Min(value=100, message="ID must be equal or greater than 100")
	@Max(value=10000, message="ID must be equal or less than 10,000")
	int campId;
	@NotEmpty(message="Camp Name is required")
	String campName;
	@NotEmpty(message="Camp location is required")
	String campLocation;
	@NotNull(message="Camp date is required")
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate campDate;
	
	long campPhoneNumber;
	
	int campPincode;
	

}
