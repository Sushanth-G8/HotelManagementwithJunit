package com.hotelmanagement.repositorytests;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hotelmanagement.api.Hotel;
import com.hotelmanagement.repository.HotelRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTests {
	
	@Autowired
	HotelRepository repository;
	
	@Test
	public void testReadDelete() {
		
		Hotel hotel= new Hotel(123,"Hotel Madhav","Kadapa",1500);
		
		repository.save(hotel);
		
		List<Hotel> hotels= repository.findAll();
		Assertions.assertThat(hotels).extracting(Hotel::getId).contains(123);
		
		 repository.deleteAll();
		 Assertions.assertThat(repository.findAll()).isEmpty();
		
		
	}

}
