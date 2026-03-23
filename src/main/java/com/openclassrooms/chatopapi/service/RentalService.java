package com.openclassrooms.chatopapi.service;

import com.openclassrooms.chatopapi.dto.RentalDTO;
import com.openclassrooms.chatopapi.dto.RentalRequestDTO;
import com.openclassrooms.chatopapi.mapper.RentalMapper;
import com.openclassrooms.chatopapi.model.Rental;
import com.openclassrooms.chatopapi.repository.RentalRepository;
import com.openclassrooms.chatopapi.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;
    private final UserRepository userRepository;
    
    @Value("${upload-full-dir}")
    private String uploadDir;
    
    @Value("${base-url}")
    private String baseUrl;

    public List<RentalDTO> getAllRentals() {
        return rentalRepository.findAll().stream()
            .map(rentalMapper::toDto)
            .map(this::getPictureUrl)
            .collect(Collectors.toList());
    }

    public RentalDTO getRentalById(Integer id) {
        Rental rental = rentalRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Rental not found"));
        RentalDTO dto = rentalMapper.toDto(rental);
        return getPictureUrl(dto);
    }

    public RentalDTO createRental(RentalRequestDTO request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Integer ownerId = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"))
            .getId();

        Rental rental = rentalMapper.toEntity(request);
        rental.setOwnerId(ownerId);
        rental.setCreatedAt(LocalDateTime.now());
        rental.setUpdatedAt(LocalDateTime.now());
        
        if (request.getPicture() != null && !request.getPicture().isEmpty()) {
            String fileName = savePicture(request.getPicture());
            rental.setPicture(fileName);
        }
        
        Rental saved = rentalRepository.save(rental);
        RentalDTO dto = rentalMapper.toDto(saved);
        return getPictureUrl(dto);
    }

    private RentalDTO getPictureUrl(RentalDTO dto) {
        if (dto.getPicture() != null && !dto.getPicture().isEmpty()) {
            dto.setPicture(baseUrl + dto.getPicture());
        }
        return dto;
    }

    private String savePicture(MultipartFile picture) {
        try {
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String fileName = UUID.randomUUID() + "_" + picture.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(picture.getInputStream(), filePath);
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save picture", e);
        }
    }

    public RentalDTO updateRental(Integer id, RentalRequestDTO request) {
        Rental rental = rentalRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Rental not found"));
        
        rentalMapper.updateEntityFromDto(request, rental);
        rental.setUpdatedAt(LocalDateTime.now());
        
        Rental updated = rentalRepository.save(rental);
        return rentalMapper.toDto(updated);
    }
}
