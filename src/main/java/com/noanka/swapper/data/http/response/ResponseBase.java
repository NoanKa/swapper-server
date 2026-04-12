package com.noanka.swapper.data.http.response;

import com.noanka.swapper.data.constant.InfoCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseBase<T> {
    private final T data;
    private final List<String> message;
    private final List<String> userMessage;
    private final boolean success;

    public ResponseBase(InfoCode infoCode, boolean success){
        this.data = null;
        this.message = infoCode.getMessage();
        this.userMessage = infoCode.getUserMessage();
        this.success = success;
    }

    public ResponseBase(T data, List<String> message, List<String> userMessage, boolean success){
        this.data = data;
        this.message = message;
        this.userMessage = userMessage;
        this.success = success;
    }
}
