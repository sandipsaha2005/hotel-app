package org.example.booking.services;

import lombok.AllArgsConstructor;
import org.example.booking.dto.BookingDto;
import org.example.booking.respsitory.BookingRepository;
import org.example.entities.booking.BookingEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public List<BookingDto> listHotels(String username) {
        return bookingRepository
                .findByUsername(username)
                .stream()
                .map(booking -> new BookingDto(
                        booking.getHotelId(),
                        booking.getRooms()
                ))
                .toList();
    }

    public String bookHotel(Long hotelId, Long rooms, String username) {
        BookingEntity booking = new BookingEntity();

        booking.setHotelId(hotelId);
        booking.setRooms(rooms);
        booking.setUsername(username);

        bookingRepository.save(booking);
        return "Booking created";
    }
}
