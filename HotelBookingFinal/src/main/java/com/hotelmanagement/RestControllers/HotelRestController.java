package com.hotelmanagement.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.api.Hotel;
import com.hotelmanagement.service.HotelService;

@RestController
public class HotelRestController {
	
	@Autowired
	HotelService hotelService;
	
	@GetMapping(value="/hotels")
	public List<Hotel> getHotels(){
		
		List<Hotel> list = hotelService.loadHotels();
		System.out.println("List" +list);
		return list;
	}

}
