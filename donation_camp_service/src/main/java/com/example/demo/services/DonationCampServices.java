package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DonationCamp;

import com.example.demo.repos.DonationCampRepository;



@Service
public class DonationCampServices {
	@Autowired
	private DonationCampRepository repo;
	
	public List<DonationCamp> findAll()
	{
		return this.repo.findAll();
	}
	public DonationCamp addDonationCamp(DonationCamp entity)
	{
		return this.repo.save(entity);
	}
	public List<DonationCamp> findByCampLocation(String loc)
	{
		return this.repo.findByCampLocation(loc);
	}
	public int remove(int campId) {
		int rowDeleted=0;
		if(this.repo.existsById(campId))
		{
			 this.repo.deleteById(campId);
			 rowDeleted=1;
		}
		return rowDeleted;
	}
	public int updateCamp(int campId,String nameToUpdate,String locationToUpdate,LocalDate dateToUpdate, long numberToUpdate,int pinToUpdate){

		return this.repo.updateCamp(campId,nameToUpdate , locationToUpdate, dateToUpdate, numberToUpdate,pinToUpdate);
		}
	
	

}
