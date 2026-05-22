package org.example.search.controller;

import lombok.AllArgsConstructor;
import org.example.search.dto.HotelDto;
import org.example.search.service.SearchService;
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
