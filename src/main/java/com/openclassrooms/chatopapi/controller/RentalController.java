package com.openclassrooms.chatopapi.controller;

import com.openclassrooms.chatopapi.dto.RentalDTO;
import com.openclassrooms.chatopapi.dto.RentalRequestDTO;
import com.openclassrooms.chatopapi.service.RentalService;
import com.openclassrooms.chatopapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Map<String, List<RentalDTO>>> getAllRentals() {
        List<RentalDTO> rentals = rentalService.getAllRentals();
        Map<String, List<RentalDTO>> response = new HashMap<>();
        response.put("rentals", rentals);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDTO> getRentalById(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.getRentalById(id));
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createRental(
            @ModelAttribute RentalRequestDTO request,
            @AuthenticationPrincipal UserDetails userDetails) {
        Integer ownerId = getOwnerIdFromUserDetails(userDetails);
        rentalService.createRental(request, ownerId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Rental created !");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateRental(
            @PathVariable Integer id,
            @ModelAttribute RentalRequestDTO request) {
        rentalService.updateRental(id, request);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Rental updated !");
        return ResponseEntity.ok(response);
    }

    private Integer getOwnerIdFromUserDetails(UserDetails userDetails) {
        return userService.getUserByEmail(userDetails.getUsername()).getId();
    }
}
