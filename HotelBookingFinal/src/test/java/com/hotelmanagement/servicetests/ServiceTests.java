package com.hotelmanagement.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelmanagement.api.Hotel;
import com.hotelmanagement.repository.HotelRepository;
import com.hotelmanagement.service.HotelService;

@SpringBootTest
public class ServiceTests {
	
	@InjectMocks
	HotelService hotelService;
	
	@Mock
	HotelRepository repository;
	
	@Test
	public void testFindAllHotels() {
		
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(new Hotel(120,"Hotel Manasa","Mumbai",2000));
		hotels.add(new Hotel(121,"Hotel Ashok","Chennai",3000));
		 
		when(repository.findAll()).thenReturn(hotels);
		List<Hotel> hotelList= hotelService.loadHotels();
		
		assertEquals(2, hotelList.size() );
		verify(repository, times(1)).findAll();
		
		
	}

}
