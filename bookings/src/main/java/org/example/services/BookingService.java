package org.example.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.dto.BookingDto;
import org.example.entity.BookingEntity;
import org.example.respsitory.BookingRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.Duration;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final StringRedisTemplate redisTemplate;

    public List<BookingDto> listHotels(String username)  {
        return bookingRepository
                .findByUsername(username)
                .stream()
                .map(booking -> new BookingDto(
                        booking.getUsername(),
                        booking.getHotelId(),
                        booking.getId(),
                        booking.getRooms(),
                        booking.getStatus()
                ))
                .toList();
    }

    public String bookHotel(Long hotelId, int rooms, String username) throws JsonProcessingException {
        BookingEntity booking = new BookingEntity();
        booking.setHotelId(hotelId);

        booking.setRooms(rooms);
        booking.setUsername(username);
        booking.setStatus("PENDING");

        bookingRepository.save(booking);
        System.out.println("booking: " +booking);
        String bookingDetails = new ObjectMapper().writeValueAsString(booking);

        redisTemplate.opsForList().leftPush("pdf-generator", bookingDetails);
        return "Booking created";
    }

    public BookingDto getInfo(Long id) {
        BookingEntity byId = bookingRepository.findById(id).orElseThrow();
        return new BookingDto(byId.getUsername(), byId.getHotelId(), byId.getId(), byId.getRooms(),byId.getStatus());
    }
}