package org.example.search.repository;

import org.example.search.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    List<HotelEntity> findByCity(String city);
}
