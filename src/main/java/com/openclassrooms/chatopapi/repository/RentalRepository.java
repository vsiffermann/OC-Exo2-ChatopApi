package com.openclassrooms.chatopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.chatopapi.model.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

}


