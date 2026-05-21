package org.example.search;

import org.example.hotel.HotelDto;
import org.example.hotel.HotelEntity;
import org.example.hotel.HotelRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    HotelRepositary hotelRepositary;

    SearchService(){
        HotelEntity hotel1 = new HotelEntity(
                null,
                "Sea View Resort",
                "Vizag",
                4500.0,
                "Siri",
                "siri@gmail.com"
        );
        HotelEntity hotel2 = new HotelEntity(
                null,
                "Sea View Resort",
                "Hyd",
                4500.0,
                "Siri",
                "siri@gmail.com"
        );
        HotelEntity hotel3 = new HotelEntity(
                null,
                "Sea View Resort",
                "Vizag",
                4500.0,
                "Siri",
                "siri@gmail.com"
        );
        hotelRepositary.save(hotel1);
        hotelRepositary.save(hotel2);
        hotelRepositary.save(hotel3);
    }


    public List<HotelDto> searchHotels(String city){


//        List<HotelDto> hotels = List.of(
//                new HotelDto(2L, "Siri's Hotel1", "vizag", 500.30),
//                new HotelDto(3L, "Siri's Hotel2", "vizag", 1000.30),
//                new HotelDto(4L, "Siri's Hotel2", "vizag", 800.30)
//        );

        List<HotelDto> hotels= hotelRepositary.findByCity(city)
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
