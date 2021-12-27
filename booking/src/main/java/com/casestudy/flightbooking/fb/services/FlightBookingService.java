package com.casestudy.flightbooking.fb.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient (name="demo",url="http://localhost:8083/fare/")
public interface FlightBookingService {
	@GetMapping("/id")
	public String getid();
	@GetMapping("/class")
	public String getclass();
	@GetMapping("/fare")
	public String fare();
}