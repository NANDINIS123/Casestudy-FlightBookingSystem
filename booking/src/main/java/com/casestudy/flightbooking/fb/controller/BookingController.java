package com.casestudy.flightbooking.fb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.flightbooking.fb.models.BookingDetails;
import com.casestudy.flightbooking.fb.repo.BookingRepo;
import com.casestudy.flightbooking.fb.services.FlightBookingServiceLayer;

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
FlightBookingServiceLayer s;
	@GetMapping("/book/{name}")
	public String add(@PathVariable String name) {
		
		try {
			BookingDetails ba=s.add(name);
			String fid=ba.getfid();
			BookingDetails b2=rp.get(fid, name);
			if(b2==null) 
			{
                rp.insert(ba);
				return "ticket is booked."+"\nname:"+name+"\nclass:"+ba.getFclass()+"\npayment:"+ba.getPayment_status();
			}
			else
				if(b2.getfid().contentEquals(fid)&&b2.getName().contentEquals(name)) {
					return "dear user a ticket is booked already with same name in same flight.check credentials to avoid financial loss";
				}
				else
					return "unusual exit";

			
		}catch(Exception e) {
			return e.getMessage();
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