package com.chat.repository;

import org.springframework.stereotype.Repository;

import com.chat.model.ChatRoom;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {

    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
