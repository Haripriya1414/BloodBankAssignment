package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonationCamp;

import com.example.demo.services.DonationCampServices;

@RestController
@RequestMapping(path = "/api/v1/camp")
public class DonationCampController {
	private DonationCampServices service;
	@Autowired
	public void setService(DonationCampServices service)
	{
		this.service=service;
	}
	@GetMapping
	public List<DonationCamp> findAll()
	{
		return this.service.findAll();
	}
	@PostMapping
	public ResponseEntity<DonationCamp> add(@RequestBody DonationCamp entity)
	{
		DonationCamp addedEntity=this.service.addDonationCamp(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
	@GetMapping(path="/location/{campLocation}")
	public List<DonationCamp> fidnByCampLocation(@PathVariable("campLocation")String campLocation)
	{
		return this.service.findByCampLocation(campLocation);
	}
	@DeleteMapping(path = "/{campId}")
	public ResponseEntity<String> removeDonor(@PathVariable("campId")int campId)
			{
				int count=this.service.remove(campId);
				HttpStatus status=HttpStatus.NOT_FOUND;
				String message="Record not found";
				if(count==1){ 
					//return ResponseEntity.ok().body(count+":+Records Deleted");
					status=HttpStatus.OK;
					message="one record deleted";
			}

					return ResponseEntity.status(status)
							.body(message);
			}
	@PutMapping(path="/{campId}/{nameToUpdate}/{locationToUpdate}/{dateToUpdate}/{numberToUpdate}/{pinToUpdate}")
	public ResponseEntity<String> updateCamp(@PathVariable("campId")int campId,@PathVariable("nameToUpdate") String nameToUpdate
	,@PathVariable("locationToUpdate") String locationToUpdate,
	@PathVariable("dateToUpdate") String dateToUpdate,@PathVariable("numberToUpdate") long numberToUpdate,@PathVariable("pinToUpdate") int pinToUpdate)
	{
	LocalDate updatedDate=LocalDate.parse(dateToUpdate);
	int count=this.service.updateCamp(campId,nameToUpdate , locationToUpdate,updatedDate,numberToUpdate,pinToUpdate);
	return ResponseEntity.ok().body(count+":+Records Updated");
	}
	
}
