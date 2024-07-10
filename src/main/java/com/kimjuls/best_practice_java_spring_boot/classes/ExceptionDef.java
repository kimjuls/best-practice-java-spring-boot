package com.kimjuls.best_practice_java_spring_boot.classes;

import org.springframework.http.HttpStatus;

public enum ExceptionDef {
    INTERNAL_SERVER_ERROR(-1, HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    NOT_FOUND(-2, HttpStatus.NOT_FOUND, "Not Found");

    int code;
    HttpStatus status;
    String message;

    ExceptionDef(int code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

}
