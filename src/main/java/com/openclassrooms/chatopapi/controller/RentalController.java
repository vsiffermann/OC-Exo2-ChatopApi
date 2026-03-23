package com.openclassrooms.chatopapi.controller;

import com.openclassrooms.chatopapi.dto.RentalDTO;
import com.openclassrooms.chatopapi.dto.RentalRequestDTO;
import com.openclassrooms.chatopapi.service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
@Tag(name = "Rentals", description = "Rental endpoints")
public class RentalController {

    private final RentalService rentalService;

    @Operation(summary = "Get all rentals")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of all rentals"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    @GetMapping
    public ResponseEntity<Map<String, List<RentalDTO>>> getAllRentals() {
        List<RentalDTO> rentals = rentalService.getAllRentals();
        Map<String, List<RentalDTO>> response = new HashMap<>();
        response.put("rentals", rentals);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get rental by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Rental found"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
        @ApiResponse(responseCode = "404", description = "Rental not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<RentalDTO> getRentalById(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.getRentalById(id));
    }

    @Operation(summary = "Create a new rental")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Rental created with success"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Map<String, String>> createRental(@ModelAttribute RentalRequestDTO request) {
        rentalService.createRental(request);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Rental created !");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update a rental")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Rental updated with success"),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
        @ApiResponse(responseCode = "404", description = "Rental not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateRental(
            @PathVariable Integer id,
            @ModelAttribute RentalRequestDTO request) {
        rentalService.updateRental(id, request);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Rental updated !");
        return ResponseEntity.ok(response);
    }
}
