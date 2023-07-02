package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Booking;
import java.util.List;


public interface BookingRepository extends JpaRepository<Booking, Integer> {

	public List<Booking> findByUserId(int userId);
	public Booking findByUserIdAndCheckInDateAndCheckOutDate(int userId, String checkInDate, String checkOutDate);
}