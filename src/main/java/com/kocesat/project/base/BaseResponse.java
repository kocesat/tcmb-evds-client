package com.kocesat.project.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BaseResponse {
    private boolean success;
    private Object data;
    private String message;

    public static BaseResponse success(Object data, String message) {
        return BaseResponse.builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static BaseResponse success(Object data) {
        return BaseResponse.builder()
                .success(true)
                .data(data)
                .build();
    }

    public static BaseResponse fail(String message) {
        return BaseResponse.builder()
                .success(false)
                .message(message)
                .build();
    }
}
