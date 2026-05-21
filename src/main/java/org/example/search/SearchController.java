package org.example.search;

import org.example.hotel.HotelDto;
import org.example.hotel.HotelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDto>> searchHotels(@RequestParam String city) {
        List<HotelDto> hotels = searchService.searchHotels(city);

        return ResponseEntity
                .ok(hotels);
    }
}
