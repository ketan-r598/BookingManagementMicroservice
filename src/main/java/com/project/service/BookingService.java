package com.project.service;

import com.project.model.Booking;

public interface BookingService {

	public Booking makeBooking(Booking book);
	public void delBooking(int bookingId);
}