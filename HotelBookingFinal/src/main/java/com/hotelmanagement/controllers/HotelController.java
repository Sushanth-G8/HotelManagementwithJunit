package com.hotelmanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelmanagement.api.Hotel;
import com.hotelmanagement.service.HotelService;

@Controller
public class HotelController {
	
	 Logger logger = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	HotelService hotelService;
	
	@GetMapping("/login")
	public String login() {
		
		logger.info("Inside Login Controller");
		
		
		return "login-page";
		
		
	}
	
	@GetMapping("/customer")
	public String customer() {
		
		logger.info("Inside Customer Controller");
		
		return "customer-login-page";
		
		
	}
	
	
	@GetMapping("/admin")
	public String admin() {
		
		logger.info("Inside admin login Controller");
		return "admin-login-page";
		
		
	}
	
	@GetMapping("/adminoperations")
	
	public String adminOperations(@RequestParam("userName") String name) {
		
	    if(name.equalsIgnoreCase("Sushanth")) {
		
		logger.info("Inside adminOperations Controller");
		
		return "admin-Operations";
	    }
	    
	    else {
	    	
	    	logger.error("Enter Correct Credentials");
	    	
	    	return "Enter Correct Credentials";
	    }
		
	}
	
	@GetMapping("/addhotel")
	public String addHotel(Model model) {
		
		logger.info("Inside AddHotel Controller");
		
		model.addAttribute("hotel", new Hotel());
		
		return "add-hotel";
	}
	
	@PostMapping("/savehotel")
	@ResponseBody
	public String saveHotel(Hotel hotel) {
		
		logger.info("Inside Save hotel Controller");
		
		if(hotel.getId()>100) {
		
		hotelService.saveHotel(hotel);
		}
		else {
			return "Please enter Correct HotelID Details";
		}
		
		return " Record Saved Successfully";
	}
	
	@GetMapping("/deletehotel")
	public String deleteHotel(Model model) {
		
		logger.info("Inside Delete Hotel Controller");
		
		return "delete-hotel";
	}
	
	@GetMapping("/deletedata")
	@ResponseBody
	public String deleteData(@RequestParam("hotelid") int id,Hotel hotel) throws HotelNotFoundException{
		
		logger.info("Inside Delete Data Controller");
		logger.info("Hotel ID is :"+ id);
		
		hotelService.deleteData(id); 
		
		
		return " Record Deleted Successfully";
	}

	
	@GetMapping(value = "/booking")
	public String showHotelList(Model model) throws NoHotelContentsException {
		
		logger.info("Inside Booking Controller");
		
		List<Hotel> hotelList = hotelService.loadHotels();
		
		if(hotelList == null) throw new NoHotelContentsException("NoHotels In the database");
		
		logger.info("List" +hotelList);
		
		model.addAttribute("hotels", hotelList);
		
		return "hotel-list";
}
	
	
	@GetMapping("/confirmbooking")
	public String confirmBooking(@RequestParam("hotelid") int id, Model model) throws HotelNotFoundException {
		
		logger.info("Inside Confirm Booking Controller");
		logger.info("Booked Hotel ID: " +id);
		
		Optional<Hotel> myhotel= hotelService.getHotel(id);
		
		if(myhotel == null) throw new HotelNotFoundException("Hotel with ID is not found");
		
		model.addAttribute("hotel",myhotel);
		
		
		
		return "confirm-hotel";
		
	}
	
	@PostMapping("/bookingstatus")
	@ResponseBody
	public String bookingStatus() {
		
		String result = "You have Successfully booked a hotel";
		
		return result;
		
	}

}