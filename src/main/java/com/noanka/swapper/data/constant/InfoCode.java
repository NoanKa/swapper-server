package com.noanka.swapper.data.constant;

import lombok.Getter;

import java.util.List;

@Getter
public enum InfoCode {
    USER_CREATED(List.of("USER_CREATED"), List.of("User created successfully"));

    private final List<String> message;
    private final List<String> userMessage;

    InfoCode(List<String> message, List<String> userMessage) {
        this.message = message;
        this.userMessage = userMessage;
    }
}
