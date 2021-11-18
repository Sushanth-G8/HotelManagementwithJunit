package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelmanagement.api.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}