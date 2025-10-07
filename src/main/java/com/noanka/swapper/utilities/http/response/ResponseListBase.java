package com.noanka.swapper.utilities.http.response;

import java.util.List;

public class ResponseListBase<T> extends PagingResponse{
    private final List<T> data;
    private final List<String> message;
    private final List<String> userMessage;
    private final boolean success;

    public ResponseListBase(List<T> data, List<String> message, List<String> userMessage, boolean success, PagingResponse pagingResponse) {
        super(pagingResponse.getIndex(), pagingResponse.getSize(), pagingResponse.getPageCount());
        this.data = data;
        this.message = message;
        this.userMessage = userMessage;
        this.success = success;
    }

    public List<T> getData() {
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
