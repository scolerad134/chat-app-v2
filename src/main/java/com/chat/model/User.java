package com.chat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.chat.model.enums.Status;

import lombok.Data;

@Data
@Document
public class User {

    @Id
    private String nickName;
    private String fullName;
    private Status status;
}
