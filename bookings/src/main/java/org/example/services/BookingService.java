package org.example.services;

import lombok.AllArgsConstructor;
import org.example.dto.BookingDto;
import org.example.entity.BookingEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {
    private final org.example.respsitory.BookingRepository bookingRepository;

    public List<BookingDto> listHotels(String username) {
        return bookingRepository
                .findByUsername(username)
                .stream()
                .map(booking -> new BookingDto(
                        booking.getUsername(),
                        booking.getHotelId(),
                        booking.getId(),
                        booking.getRooms()
                        ))
                .toList();
    }

    public String bookHotel(Long hotelId, int rooms, String username) {
        BookingEntity booking = new BookingEntity();
        booking.setHotelId(hotelId);
        booking.setRooms(rooms);
        booking.setUsername(username);

        bookingRepository.save(booking);
        return "Booking created";
    }

    public BookingDto getInfo(Long id) {
       BookingEntity byId = bookingRepository.findById(id).orElseThrow();
        return new BookingDto(byId.getUsername(), byId.getHotelId(), byId.getId(), byId.getRooms());
    }
}
