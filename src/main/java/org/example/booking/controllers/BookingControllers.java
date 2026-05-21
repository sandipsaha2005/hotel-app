package org.example.booking.controllers;

import lombok.AllArgsConstructor;
import org.example.booking.dto.BookingDto;
import org.example.booking.dto.BookingRequest;
import org.example.booking.services.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BookingControllers {

    private final BookingService bookingService;

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDto>> listBookings() {
        List<BookingDto> bookings = bookingService.listHotels();
        return ResponseEntity.ok(bookings);
    }

    @PostMapping("/bookings")
    public ResponseEntity<String> bookHotel(@RequestBody BookingRequest request) {
        String s = bookingService.bookHotel(request.hotel_id(), request.rooms());
        return ResponseEntity.ok(s);
    }

}
