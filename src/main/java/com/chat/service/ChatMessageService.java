package com.chat.service;


import com.chat.exceptions.CreateChatException;
import com.chat.model.ChatMessage;
import com.chat.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        String chatId = chatRoomService.getChatRoomId(
                chatMessage.getSenderId(),
                chatMessage.getRecipientId(),
                true)
                .orElseThrow(CreateChatException::new);

        chatMessage.setChatId(chatId);
        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        Optional<String> chatId = chatRoomService.getChatRoomId(
                senderId, recipientId, false);

        return chatId.map(chatMessageRepository.findByChatId).orElse(new ArrayList<>());
    }
}
