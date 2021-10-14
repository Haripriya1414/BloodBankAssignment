package com.example.demo.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import com.example.demo.entity.Donor;
@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {

	public List<Donor> findByBloodGroup(String key);
	public List<Donor> findByLocation(String loc);
	public List<Donor> findByLastDonation(String date);
	public boolean existsById(int donorId);
	public void deleteById(int donorId);
	@Query(nativeQuery = true,value = "update donor set donorname=:name, bloodGroup=:group, age=:ageno, location=:location, phoneNumber=:phn, lastDonation=:predate, pincode=:pin where donorId=:number")
	@Modifying
	@Transactional
	public int updateDonor(@Param("number") int donorId, @Param("name") String nameToUpdate, @Param("group") String groupToUpdate, @Param("ageno") int ageToUpdate,@Param("location") String locationToUpdate,
	@Param("phn") long numToUpdate, @Param("predate") LocalDate dateToUpdate, @Param("pin") int pinToUpdate);

}
