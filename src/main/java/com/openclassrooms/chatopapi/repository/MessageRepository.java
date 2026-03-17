package com.openclassrooms.chatopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.chatopapi.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
