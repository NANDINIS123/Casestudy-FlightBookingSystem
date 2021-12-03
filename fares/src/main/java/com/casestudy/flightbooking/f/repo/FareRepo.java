package com.casestudy.flightbooking.f.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.casestudy.flightbooking.f.model.FareDetails;

import com.google.common.base.Optional;

public interface FareRepo extends MongoRepository<FareDetails,String>{
	@Query("{'fid':?0}")
	public Optional<FareDetails>getinfo(String fid);
	@Query("{'fid':?0}")
	public FareDetails getobj(String fid);
	




	
}
