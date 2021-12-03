package com.casestudy.flightbooking.fb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.flightbooking.fb.models.BookingDetails;
import com.casestudy.flightbooking.fb.repo.BookingRepo;
import com.casestudy.flightbooking.fb.service.FlightBookingService;

/*@RestController
@RequestMapping("/booking")
public class BookingController {
@RequestMapping("/hey")
public String hey() {
	return "welcome to booking";
}
@RequestMapping("/count")
public String getBookingDetails() {
	System.out.println("In Controller class for count");
	return "getFlightsDetails : ";
}
}*/

@RestController
@RequestMapping("/booking")
public class BookingController {
@Autowired
BookingRepo rp;

@Autowired
FlightBookingService fs1;

private String fid;

private String fare;

private String fclass;

public String Name;

public String status;

@GetMapping("/book/{name}")
public String add(@PathVariable String name) {
	try {
		this.fid=fs1.getid();
		this.fare=fs1.fare();
		this.fclass=fs1.getclass();
		status="booked";
		this.Name=name;
		BookingDetails b1=new BookingDetails(fid,fare,fclass,status,name);
			rp.save(b1);
			return "booked."+"name:"+name+"\nclass:"+b1.getFclass()+"\npayment:"+b1.getPayment();
		
	}catch(Exception e) {
		return "cannot book";
	}	
}	
@GetMapping("/cancel/{fid}/{name}")
public String cancel(@PathVariable String fid,@PathVariable String name){
	try
  	{ 
    BookingDetails b1=rp.get(fid, name);
  	rp.delete(fid, name);
  	b1.setStatus("cancelled"); 
  	rp.insert(b1);
  	return "booking canceled"; 
  }catch(Exception e) { 
	  return e.getMessage();
	  }
}
 
 @GetMapping("/mybookings/{name}")
 public List<BookingDetails>getdata(@PathVariable String name){
	 return rp.get(name);
 }		
}