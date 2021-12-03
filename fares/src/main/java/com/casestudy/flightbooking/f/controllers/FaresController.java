package com.casestudy.flightbooking.f.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.flightbooking.f.model.FareDetails;
import com.casestudy.flightbooking.f.repo.FareRepo;
import com.casestudy.flightbooking.f.services.FlightBookingService;
import com.google.common.base.Optional;

/*import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fares")
public class fares_controller {
@RequestMapping("/hey")
public String hey() {
	return "welcome to fares";
}
}*/

@RestController
@RequestMapping("/fare")
public class FaresController {
@Autowired
FareRepo rp;
FlightBookingService s1=new FlightBookingService();

@GetMapping("/{id}")
public Optional<FareDetails> getfare(@PathVariable String id) {
	return rp.getinfo(id);
}
@PostMapping("/getfare/add")
public String add(@RequestBody FareDetails f1) {
	try {
		rp.insert(f1);
		return "sucess";
	}catch(Exception e) {
		return "sorry problem in creation ";
	}
}
@GetMapping("/{id}/{type}/select")
public String getfare(@PathVariable String id,@PathVariable String type) {
	FareDetails f1=rp.getobj(id);
	return "your seat is selected.please confirm.\nformat:class,fare\n"+s1.getdata(f1, type)+","+s1.fr();
}

@GetMapping("/{id}/{type}/select/confirm")
public String getcon() {
	return "flight id:"+s1.fid();
}
@GetMapping("/id")
public String getid() {
	return s1.fid();
}
@GetMapping("/class")
public String getclass() {
	return s1.fcl();
}
@GetMapping("/fare")
public String fare() {
	return s1.fr();
}
}
