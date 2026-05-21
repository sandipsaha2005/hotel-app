package org.example.hotel;

@FunctionalInterface
public interface HotelProjector<T> {
    T project(Long id, String name, String city, Double price);
}

