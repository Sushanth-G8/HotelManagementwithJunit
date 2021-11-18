package com.hotelmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.api.Hotel;
import com.hotelmanagement.controllers.HotelNotFoundException;
import com.hotelmanagement.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	HotelRepository repository;
	
	public List<Hotel> loadHotels(){
		
		return(List<Hotel>) repository.findAll();
		
	}
	
public Optional<Hotel> getHotel(int id) {
		
		Optional<Hotel> hotel = repository.findById(id);	
		
		return hotel;
	}

public void saveHotel(Hotel hotel) {
	repository.save(hotel);
	
}

public void deleteData(int id) throws HotelNotFoundException {
	
	if(repository.existsById(id)) { 
  repository.deleteById(id);
	}
	else {
		throw new HotelNotFoundException("Hotel with Id doesn't exist");
	}
	
}



}
