package com.weshare.manage.cto;

import org.springframework.http.HttpStatus;

public class HttpResponse {

    private int code;

    private String message;

    private Object data;

    public HttpResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public HttpResponse (Object data) {
        this.code = HttpStatus.OK.value();
        this.message = HttpStatus.OK.getReasonPhrase();
        this.data = data;
    }

    public HttpResponse (HttpStatus httpStatus, Object data) {
        this.code = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
