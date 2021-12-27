package com.casestudy.flightbooking.fb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.flightbooking.fb.models.BookingDetails;

@Service
	public class FlightBookingServiceLayer {
		@Autowired
		FlightBookingService fs1;
		String fid,fare,fclass,status,name;
		public BookingDetails add(String name) {
			this.fid=fs1.getid();
			this.fare=fs1.fare();
			this.fclass=fs1.getclass();
			status="booked";
			this.name=name;
			BookingDetails b1=new BookingDetails(fid,fare,fclass,status,name,"np");
			return b1;
		}
	

}
