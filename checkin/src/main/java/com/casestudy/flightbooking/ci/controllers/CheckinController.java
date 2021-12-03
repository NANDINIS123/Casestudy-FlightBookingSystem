package com.casestudy.flightbooking.ci.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkin")
public class CheckinController {
@RequestMapping("/hey")
public String hey() {
	return "welcome to checkin";
}
}

