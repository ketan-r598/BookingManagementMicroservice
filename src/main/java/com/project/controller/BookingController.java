package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Booking;
import com.project.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	@PostMapping("/users/booking/makeBooking")
	public Booking makeBooking(@RequestBody Booking book) {
		return service.makeBooking(book);
	}
	
	
	@DeleteMapping("/users/booking/cancelBooking/{bookingId}")
	public void deleteBooking(@PathVariable int bookingId) {
		service.delBooking(bookingId);
	}
}