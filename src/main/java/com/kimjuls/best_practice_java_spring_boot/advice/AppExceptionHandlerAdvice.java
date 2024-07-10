package com.kimjuls.best_practice_java_spring_boot.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kimjuls.best_practice_java_spring_boot.classes.AppException;
import com.kimjuls.best_practice_java_spring_boot.classes.BaseResponse;

@RestControllerAdvice
public class AppExceptionHandlerAdvice {
    @ExceptionHandler()
    public ResponseEntity<BaseResponse> handleCommonException(Exception e) {
        if (e instanceof AppException) {
            int code = ((AppException) e).getCode();
            String message = e.getMessage();
            HttpStatus status = ((AppException) e).getStatus();
            return new ResponseEntity<>(new BaseResponse(code, message), status);
        } else {
            return new ResponseEntity<>(new BaseResponse(-1, "Internal Server Error"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
