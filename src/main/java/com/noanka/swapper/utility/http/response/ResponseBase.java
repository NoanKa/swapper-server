package com.noanka.swapper.utility.http.response;

import java.util.List;

public class ResponseBase<T> {
    private T data;
    private List<String> message;
    private List<String> userMessage;
    private boolean success;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public List<String> getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(List<String> userMessage) {
        this.userMessage = userMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
