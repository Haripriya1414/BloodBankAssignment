package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Donor;

import com.example.demo.repos.DonorRepository;

@Service
public class DonorService {
	@Autowired
	private DonorRepository repo;
	public List<Donor> findAll()
	{
		return this.repo.findAll();
	}
	public Donor addDonor(Donor entity)
	{
		return this.repo.save(entity);
	}
	public List<Donor> findByBloodGroup(String key)
	{
		//return this.repo.findById(key).get();
		return this.repo.findByBloodGroup(key);
	}
	public List<Donor> findByLocation(String loc)
	{
		return this.repo.findByLocation(loc);
	}
	//remove
	public int remove(int donorId) {
		int rowDeleted=0;
		if(this.repo.existsById(donorId))
		{
			 this.repo.deleteById(donorId);
			 rowDeleted=1;
		}
		return rowDeleted;
	}
	public int updateDonor(int donorId,String nameToUpdate,String groupToUpdate,int ageToUpdate, String locationToUpdate, long numToUpdate, LocalDate dateToUpdate, int pinToUpdate){
		return this.repo.updateDonor(donorId,nameToUpdate, groupToUpdate, ageToUpdate,locationToUpdate, numToUpdate, dateToUpdate, pinToUpdate);
		}
		


}
