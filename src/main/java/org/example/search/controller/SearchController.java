package org.example.search.controller;

import lombok.AllArgsConstructor;
<<<<<<< Updated upstream:src/main/java/org/example/search/controller/SearchController.java
import org.example.search.dto.HotelDto;
import org.example.search.service.SearchService;
=======
import org.example.entities.hotel.HotelDto;
>>>>>>> Stashed changes:src/main/java/org/example/search/SearchController.java
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
