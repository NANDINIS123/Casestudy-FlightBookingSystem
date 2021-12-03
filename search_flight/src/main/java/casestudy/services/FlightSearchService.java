package casestudy.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import casestudy.repo.FlightSearchRepository;

@Service
public class FlightSearchService {
	@Autowired
	private FlightSearchRepository flightSearchRepository;

	public long count() {
		System.out.println("In Service class");
		return flightSearchRepository.count();
	}

	 



}

