package com.project.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.model.Booking;
import com.project.repository.BookingRepository;

class BookingServiceTests {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMakeBooking() {
        Booking booking = new Booking();
        booking.setBookingId(1);
        booking.setUserId(1);
        booking.setRoomId(1);
        booking.setCheckInDate("2023-06-01");
        booking.setCheckOutDate("2023-06-05");
        booking.setAmount(500.0f);
        booking.setStatus("Confirmed");

        when(bookingRepository.save(booking)).thenReturn(booking);

        Booking result = bookingService.makeBooking(booking);

        assertNotNull(result);
        assertEquals(booking, result);
        verify(bookingRepository, times(1)).save(booking);
    }

    @Test
    void testDelBooking() {
        int bookingId = 1;

        assertDoesNotThrow(() -> bookingService.delBooking(bookingId));
        verify(bookingRepository, times(1)).deleteById(bookingId);
    }
}