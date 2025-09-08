package com.chat.exceptions;

public class CreateChatException extends RuntimeException {
    public CreateChatException() {
        super();
    }

    public CreateChatException(String message) {
        super(message);
    }

    public CreateChatException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateChatException(Throwable cause) {
        super(cause);
    }
}
