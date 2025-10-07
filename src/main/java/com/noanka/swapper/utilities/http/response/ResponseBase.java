package com.noanka.swapper.utilities.http.response;

import java.util.List;

public class ResponseBase<T> {
    private final T data;
    private final List<String> message;
    private final List<String> userMessage;
    private final boolean success;

    public ResponseBase(List<String> message, List<String> userMessage, boolean success){
        this.data = null;
        this.message = message;
        this.userMessage = userMessage;
        this.success = success;
    }

    public ResponseBase(T data, List<String> message, List<String> userMessage, boolean success){
        this.data = data;
        this.message = message;
        this.userMessage = userMessage;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public List<String> getMessage() {
        return message;
    }

    public List<String> getUserMessage() {
        return userMessage;
    }

    public boolean isSuccess() {
        return success;
    }
}
