package casestudy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import casestudy.models.FlightDetails;
import casestudy.repo.FlightSearchRepository;
import casestudy.services.FlightSearchService;

/*
@RestController
@RequestMapping("/search_flights")
public class FlightSearchController {
	@Autowired
	private FlightSearchService flightSearchService;
	
	@RequestMapping("/hey")
	public String hey() {
		System.out.println("In Controller class for hey");
		return "welcome to search flight";
	}
	
	@RequestMapping("/count")
	public String getFlightsDetails() {
		System.out.println("In Controller class for count");
		return "getFlightsDetails : "+flightSearchService.findAll();
		

	
	}
}*/

@RestController
@RequestMapping("/search")
public class FlightSearchController {
	@Autowired
	FlightSearchRepository rp;
	@GetMapping("/flight/{route}/{date}")
	public List<FlightDetails> getdata(@PathVariable String route,@PathVariable String date){		
		return rp.findflight(route,date);
	}
	@PostMapping("/flight/add")
	public String getdata(@RequestBody FlightDetails f1){		
		try {
			rp.insert(f1);
			return "sucessful insert";
		}catch(Exception e) {
			return "sorry unable to insert";
		}
	}
}