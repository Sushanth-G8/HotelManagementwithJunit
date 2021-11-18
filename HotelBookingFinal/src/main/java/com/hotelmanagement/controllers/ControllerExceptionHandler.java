package com.hotelmanagement.controllers;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {
	
	@ExceptionHandler(HotelNotFoundException.class)
	public String resourceNotFoundException(HotelNotFoundException ex){
		
		return ex.getMessage();
	}
	
	@ExceptionHandler(NoHotelContentsException.class)
	@ResponseBody
	public String noContentException(NoHotelContentsException ex) {
		
		return ex.getMessage();
	}

}
