package com.openclassrooms.chatopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.chatopapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
