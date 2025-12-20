package com.noanka.swapper.module.offer.controller.http.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class CreateTicketRequest {
    @NotNull
    @Max(100)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
