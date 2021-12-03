package casestudy.repo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

//import com.casestudy.flightbooking.fb.models.BookingDetails;

//import com.casestudy.flightbooking.fb.models.BookingDetails;

import casestudy.models.FlightDetails;

public interface FlightSearchRepository extends MongoRepository<FlightDetails, String>{

	@Query("{'route':?0,'date':?1}")
	List<FlightDetails>findflight(String route,String date);
	

	
	
	

}
