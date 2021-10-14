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

import com.example.demo.entity.Donor;

import com.example.demo.services.DonorService;


@RestController
@RequestMapping(path = "/api/v1/donors")
public class DonorController {
	private DonorService service;
	@Autowired
	public void setService(DonorService service)
	{
		this.service=service;
	}
	//get all data
	@GetMapping
	public List<Donor> findAll()
	{
		return this.service.findAll();
	}
	//get the data
	@GetMapping(path="/{bloodGroup}")
	public List<Donor> fidnByBloodGroup(@PathVariable("bloodGroup")String bloodGroup)
	{
		return this.service.findByBloodGroup(bloodGroup);
	}
	@GetMapping(path="/location/{location}")
	public List<Donor> fidnByLocation(@PathVariable("location")String location)
	{
		return this.service.findByLocation(location);
	}
	@PostMapping
	public ResponseEntity<Donor> add(@RequestBody Donor entity)
	{
		Donor addedEntity=this.service.addDonor(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
	@DeleteMapping(path = "/{donorId}")
	public ResponseEntity<String> removeDonor(@PathVariable("donorId")int donorId)
			{
				int count=this.service.remove(donorId);
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
	//update data
	@PutMapping(path="/{donorId}/{nameToUpdate}/{groupToUpdate}/{ageToUpdate}/{locationToUpdate}/{numToUpdate}/{dateToUpdate}/{pinToUpdate}")
	public ResponseEntity<String> updateDonor(@PathVariable("donorId")int donorId, @PathVariable("nameToUpdate") String nameToUpdate, @PathVariable("groupToUpdate") String groupToUpdate,@PathVariable("ageToUpdate") int ageToUpdate, @PathVariable("locationToUpdate") String locationToUpdate,@PathVariable("numToUpdate") long numToUpdate, @PathVariable("dateToUpdate") String dateToUpdate, @PathVariable("pinToUpdate") int pinToUpdate)
	{
	LocalDate upd=LocalDate.parse(dateToUpdate);
	int count=this.service.updateDonor(donorId, nameToUpdate, groupToUpdate,ageToUpdate,locationToUpdate,numToUpdate,upd,pinToUpdate);
	return ResponseEntity.ok().body(count+":+Records Updated");
	}
	

}
