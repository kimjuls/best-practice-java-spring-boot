package com.kimjuls.best_practice_java_spring_boot.classes;

import org.springframework.http.HttpStatus;

public class AppException extends Exception {
    private int code;
    private HttpStatus status;
    private String message;

    public AppException(ExceptionDef ed) {
        super(ed.message);
        this.code = ed.code;
        this.status = ed.status;
        this.message = ed.message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
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

}
