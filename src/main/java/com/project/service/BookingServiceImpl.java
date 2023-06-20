package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Booking;
import com.project.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository repo;
	@Override
	public Booking makeBooking(Booking book) {
		return repo.save(book);
	}

	@Override
	public void delBooking(int bookingId) {
		repo.deleteById(bookingId);
	}

}
