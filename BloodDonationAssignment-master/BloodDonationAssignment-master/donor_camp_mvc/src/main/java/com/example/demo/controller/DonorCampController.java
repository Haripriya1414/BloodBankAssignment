package com.example.demo.controller;
import java.util.Arrays;



import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.Camp;
import com.example.demo.data.Donor;

@Controller
public class DonorCampController {

@Autowired
private Donor object;

@Autowired
private Camp obj;

@Autowired
private ModelAndView mdlView;

@Autowired
private RestTemplate template;

@RequestMapping(value="/",method=RequestMethod.GET)
public String init(Model model) {
model.addAttribute("majHeading","BLOOD DONATION CAMP");
return "index";
}
//Adding Donor
@GetMapping(path="/addDonor")
public String sendDonorDetails(Model model) {
	model.addAttribute("donor",object);
	return "addDonor";
}
@PostMapping(path="/addDonor")
public String submitDonorDetails(@Valid @ModelAttribute("donor") Donor donor,BindingResult result) {
	String nextStep = "success";

	if(result.hasErrors()) {
		nextStep = "addDonor";
	}else 
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Donor> requestBody = new HttpEntity<>(donor,headers);
		template.postForObject("http://localhost:1010/api/v1/donors", requestBody, Donor.class);
	}
return nextStep;
}

//Display all donors
@GetMapping(path = "/getAllDonors")
public String findAll(Model model) {
	Donor[] resp =template.getForObject("http://localhost:1010/api/v1/donors",
			Donor[].class);
	model.addAttribute("donors",resp);
	return "displayDonors";
}
//display donors details based on the blood group
@GetMapping(path = "/getBloodGroup")
public String findByBloodGroup(Model model,String search) {
	Donor[] resp =template.getForObject("http://localhost:1010/api/v1/donors/"+search,
			Donor[].class);
	if(resp.length>0) {
	model.addAttribute("donors",resp);
return "displayDonors";
}
	else
	{
		return "bloodGroupNotAvailable";
	}
}

//display donors details based on location
@GetMapping(path = "/getLocation")
public String findByLocation(Model model,String location) {
	Donor[] resp =template.getForObject("http://localhost:1010/api/v1/donors/location/"+location,
			Donor[].class);
	if(resp.length>0) {
	model.addAttribute("donors",resp);
return "displayDonors";
}
	else
	{
		return "locationNotAvailable";
	}
}
//Deleting donor
@GetMapping(path="/unregister")
public String removeDonor(Model model,int value)
{
	template.delete("http://localhost:1010/api/v1/donors/"+value,Donor[].class);
			return "delete";
}

//updating Donor
@GetMapping(path="/updatedonor")
public String updateDonor(Model model,int donorId, String donorName, String bloodGroup,int ageno, String donorLocation, long num, String preDate,int pinCode)
{
template.put("http://localhost:1010/api/v1/donors/"+donorId+"/"+donorName+"/"+bloodGroup+"/"+ageno+"/"+donorLocation+"/"+num+"/"+preDate+"/"+pinCode,Donor[].class);
return "update";
}

//Adding camp details
@GetMapping(path="/addCamp")
public String sendCampDetails(Model model) {
	model.addAttribute("camp",obj);
	return "addCamp";
}
@PostMapping(path="/addCamp")
public String submitCampDetails(@Valid @ModelAttribute("camp") Camp camp,BindingResult result) {
	String nextStep = "success";

	if(result.hasErrors()) {
		nextStep = "addCamp";
	}else 
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Camp> requestBody = new HttpEntity<>(camp,headers);
		template.postForObject("http://localhost:2020/api/v1/camp", requestBody, Camp.class);
	}
return nextStep;
}


//Display camp details
@GetMapping(path = "/getAllCamp")
public String findAllCamp(Model model) {
	Camp[] response =template.getForObject("http://localhost:2020/api/v1/camp",
			Camp[].class);
	model.addAttribute("camp",response);
	return "displayCamp";
}

//updating camp details
@GetMapping(path="/updateCamp")
public String updateCamp(Model model,int id,String name,String location,String date,long num,int pin)
{ // LocalDate lbd=LocalDate.parse(date);
template.put("http://localhost:2020/api/v1/camp/"+id+"/"+name+"/"+location+"/"+date+"/"+num+"/"+pin,Camp[].class);
return "update";
}

//Display camp details by location
@GetMapping(path = "/getByCampLocation")
public String findByCampLocation(Model model,String camplocation) {
	Camp[] resp =template.getForObject("http://localhost:2020/api/v1/camp/location/"+camplocation,
			Camp[].class);
	if(resp.length>0) {
	model.addAttribute("camp",resp);
return "displayCamp";
}
	else
	{
		return "locationNotAvailable";
	}
}
//delete camp details

@GetMapping(path="/unregisterCamp")
public String removeCamp(Model model,int unregister)
{
	template.delete("http://localhost:2020/api/v1/camp/"+unregister,Camp[].class);
			return "delete";
}
}