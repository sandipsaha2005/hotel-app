package org.example.search;

import lombok.AllArgsConstructor;
import org.example.entities.hotel.HotelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDto>> searchHotels(@RequestParam String city) {
        List<HotelDto> hotels = searchService.searchHotels(city);

        return ResponseEntity
                .ok(hotels);
    }
}
