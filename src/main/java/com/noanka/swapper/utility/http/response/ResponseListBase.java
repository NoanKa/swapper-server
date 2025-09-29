package com.noanka.swapper.utility.http.response;

import java.util.List;

public class ResponseListBase<T> {
    private List<T> data;
    private List<String> message;
    private List<String> userMessage;
    private boolean success;
}
