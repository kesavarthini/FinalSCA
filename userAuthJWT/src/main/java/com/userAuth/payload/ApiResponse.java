package com.userAuth.payload;

import lombok.Data;

@Data
public class ApiResponse {

    private Boolean success;
    private Object data;

    public ApiResponse(Object data, Boolean success, String message) {
        this.success = success;
        this.data = data;
    }
}
