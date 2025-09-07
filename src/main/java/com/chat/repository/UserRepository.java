package com.chat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chat.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByStatus(com.chat.model.enums.Status status);
}