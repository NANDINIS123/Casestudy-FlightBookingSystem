package com.casestudy.flightbooking.ci.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.flightbooking.ci.models.CheckinDetails;
import com.casestudy.flightbooking.ci.repo.CheckinRepo;
import com.casestudy.flightbooking.ci.services.CheckinService;


/*@RestController
@RequestMapping("/checkin")
public class CheckinController {
@RequestMapping("/hey")
public String hey() {
	return "welcome to checkin";
}
}*/

@RestController
@RequestMapping("/checkin")
public class CheckinController {
	@Autowired
	CheckinRepo rp;
	@Autowired
	CheckinService c2;
	
	@GetMapping("/{name}/{fid}")
	public String hey(@PathVariable String name,@PathVariable String fid) {
		CheckinDetails b1=rp.get(name, fid);
		if(b1.getPayment_status().contains("np")) {
			return "pay the fare";
		}
		else
		return c2.getfrd(fid);
	}
}

