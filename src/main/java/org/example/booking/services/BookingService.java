package org.example.booking.services;

import lombok.AllArgsConstructor;
import org.example.booking.dto.BookingDto;
import org.example.booking.entities.BookingEntity;
import org.example.booking.respsitory.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public List<BookingDto> listHotels() {
        return bookingRepository
                .findAll()
                .stream()
                .map(booking -> new BookingDto(
                        booking.getHotelId(),
                        booking.getRooms()
                ))
                .toList();
    }

    public String bookHotel(Long hotelId, Long rooms) {
        BookingEntity booking = new BookingEntity();

        booking.setHotelId(hotelId);
        booking.setRooms(rooms);

        bookingRepository.save(booking);
        return "Booking created";
    }
}
