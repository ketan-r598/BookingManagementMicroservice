package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Booking;
import com.project.repository.BookingRepository;
import com.project.service.BookingService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/bookings/customer/")
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	@Autowired
	private BookingRepository repo;
	
	@PostMapping("makeBooking")
	public Booking makeBooking(@RequestBody Booking book) {
		return service.makeBooking(book);
	}
	
	@DeleteMapping("cancelBooking/{bookingId}")
	public ResponseEntity<Map<String, Boolean>> deleteBooking(@PathVariable int bookingId) {
		service.delBooking(bookingId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("getBooking/{id}")
	public Booking getBooking(@PathVariable int id) {
		return repo.findById(id).get();
	}
	
	@GetMapping("getBookingByUserId/{userId}")
	public List<Booking> getBookingByUserId(@PathVariable int userId) {
		return repo.findByUserId(userId);
	}
	
	@GetMapping("getBookings/{userId}/{checkInDate}/{checkOutDate}")
	public Booking getBookings(@PathVariable int userId, @PathVariable String checkInDate, @PathVariable String checkOutDate) {
		return repo.findByUserIdAndCheckInDateAndCheckOutDate(userId, checkInDate, checkOutDate);
	}
}