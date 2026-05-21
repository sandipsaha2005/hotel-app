package org.example.hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepositary extends JpaRepository<HotelEntity, Long> {
    List<HotelEntity> findByCity(String city);
}
