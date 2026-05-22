package org.example.search.service;

import lombok.AllArgsConstructor;
import org.example.search.dto.HotelDto;
import org.example.search.entity.HotelEntity;
import org.example.search.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchService {

    private HotelRepository hotelRepository;

    private void init() {

        List<HotelEntity> hotels = List.of(

                new HotelEntity(null, "Sea View Resort", "Visakhapatnam", 4500.0, "Siri", "siri@gmail.com"),
                new HotelEntity(null, "Mountain Breeze Hotel", "Darjeeling", 5200.0, "Rahul", "rahul@gmail.com"),
                new HotelEntity(null, "Royal Palace Inn", "Jaipur", 6100.0, "Ananya", "ananya@gmail.com"),
                new HotelEntity(null, "Lake Side Retreat", "Udaipur", 7000.0, "Vikram", "vikram@gmail.com"),
                new HotelEntity(null, "Urban Stay", "Bangalore", 3900.0, "Neha", "neha@gmail.com"),
                new HotelEntity(null, "City Lights Hotel", "Mumbai", 8500.0, "Arjun", "arjun@gmail.com"),
                new HotelEntity(null, "Green Valley Resort", "Manali", 4800.0, "Priya", "priya@gmail.com"),
                new HotelEntity(null, "Sunrise Residency", "Chennai", 3500.0, "Karan", "karan@gmail.com"),
                new HotelEntity(null, "Golden Sands Hotel", "Goa", 9200.0, "Meera", "meera@gmail.com"),
                new HotelEntity(null, "Hilltop Paradise", "Shimla", 5600.0, "Rohit", "rohit@gmail.com"),
                new HotelEntity(null, "Palm Tree Suites", "Kochi", 4300.0, "Sneha", "sneha@gmail.com"),
                new HotelEntity(null, "Skyline Inn", "Hyderabad", 4100.0, "Amit", "amit@gmail.com"),
                new HotelEntity(null, "Blue Lagoon Resort", "Pondicherry", 6700.0, "Divya", "divya@gmail.com"),
                new HotelEntity(null, "Heritage Grand", "Kolkata", 5900.0, "Sourav", "sourav@gmail.com"),
                new HotelEntity(null, "Riverfront Hotel", "Ahmedabad", 4600.0, "Pooja", "pooja@gmail.com"),
                new HotelEntity(null, "The Elite Stay", "Delhi", 7800.0, "Nikhil", "nikhil@gmail.com"),
                new HotelEntity(null, "Cloud Nine Resort", "Ooty", 5300.0, "Riya", "riya@gmail.com"),
                new HotelEntity(null, "Desert Pearl Hotel", "Jaisalmer", 6400.0, "Manoj", "manoj@gmail.com"),
                new HotelEntity(null, "Ocean Bliss Resort", "Andaman", 9800.0, "Kavya", "kavya@gmail.com"),
                new HotelEntity(null, "Metro Plaza", "Pune", 4200.0, "Harsh", "harsh@gmail.com")

        );

        hotelRepository.saveAll(hotels);
    }
    public List<HotelDto> searchHotels(String city){
//        this.init();

        List<HotelDto> hotels= hotelRepository.findByCity(city)
                .stream()
                .map(hotel -> new HotelDto(
                        hotel.getId(),
                        hotel.getName(),
                        hotel.getCity(),
                        hotel.getPrice()
                ))
                .toList();

        return hotels;
    }

}
