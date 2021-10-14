package com.example.demo.repos;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DonationCamp;

@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp, Integer> {
	public List<DonationCamp> findByCampLocation(String loc);
	public boolean existsById(int campId);
	public void deleteById(int campId);
	@Query(nativeQuery = true,value = "update donation_camp set campName=:name,campLocation=:location,campDate=:campdate,campPhoneNumber=:phonenumber,campPincode=:pincode where campId=:number")
	@Modifying
	@Transactional
	public int updateCamp(@Param("number") int campId, @Param("name") String nameToUpdate, @Param("location") String locationToUpdate
	,@Param("campdate") LocalDate dateToUpdate,@Param("phonenumber") long numberToUpdate,@Param("pincode") int pinToUpdate);
		
}
