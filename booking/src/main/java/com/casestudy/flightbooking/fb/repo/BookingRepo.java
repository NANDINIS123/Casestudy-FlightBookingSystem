package com.casestudy.flightbooking.fb.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.casestudy.flightbooking.fb.models.BookingDetails;
public interface BookingRepo extends MongoRepository <BookingDetails,String>
{
	@Query("{'name':?0}")
	public List<BookingDetails> get(String name);
	
	@Query("{'fid':?0,'name':?1}")
	public BookingDetails get(String fid,String name);
	
    @Query(value="{'fid' : ?0,'name':?1}", delete = true)
    public BookingDetails delete(String fid,String name);
	
}