package org.example.controllers;

import lombok.AllArgsConstructor;

import org.springframework.security.core.Authentication;
import org.example.dto.BookingDto;
import org.example.dto.BookingRequest;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BookingControllers {

    private final org.example.services.BookingService bookingService;

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDto>> listBookings(Authentication authentication) {
        String username = authentication.getName();
        List<BookingDto> bookings = bookingService.listHotels(username);
        return ResponseEntity.ok(bookings);
    }

    @PostMapping("/bookings")
    public ResponseEntity<String> bookHotel(Authentication authentication, @RequestBody BookingRequest request) {
        String name = authentication.getName();
        String s = bookingService.bookHotel(request.hotel_id(), request.rooms(), name);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/bookings/{id}/receipt.pdf")
    public ResponseEntity<BookingDto> downloadReceipt(@PathVariable Long id){
        BookingDto info = bookingService.getInfo(id);
        return ResponseEntity.ok(info);
    }
}
