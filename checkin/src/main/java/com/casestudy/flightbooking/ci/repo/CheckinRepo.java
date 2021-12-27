package com.casestudy.flightbooking.ci.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.casestudy.flightbooking.ci.models.CheckinDetails;

public interface CheckinRepo extends MongoRepository<CheckinDetails,String>{
@Query("{'name':?0,'fid':?1}")
CheckinDetails get(String name,String fid);
}