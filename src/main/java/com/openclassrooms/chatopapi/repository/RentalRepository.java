package com.openclassrooms.chatopapi.repository;

import com.openclassrooms.chatopapi.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {

}


