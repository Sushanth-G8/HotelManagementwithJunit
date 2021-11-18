package com.hotelmanagement.controllertests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.hotelmanagement.RestControllers.HotelRestController;
import com.hotelmanagement.api.Hotel;
import com.hotelmanagement.service.HotelService;

@WebMvcTest(HotelRestController.class)
public class ControllerTests {
	
	@MockBean
	HotelService hotelService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testFindAll() throws Exception {
		
		Hotel hotel = new Hotel(109,"Hotel Mayura","Vizag",4000);
		List<Hotel> hotels = new ArrayList<>();
		hotels.add(hotel);
		Mockito.when(hotelService.loadHotels()).thenReturn(hotels);
		
		mockMvc.perform(get("/hotels"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasSize(1)))
		.andExpect(jsonPath("$[0].id", Matchers.is(109)));
		         
		}

}
