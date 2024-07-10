package com.kimjuls.best_practice_java_spring_boot.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.kimjuls.best_practice_java_spring_boot.classes.AppResponse;
import com.kimjuls.best_practice_java_spring_boot.classes.BaseResponse;

@RestControllerAdvice
public class AppResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @SuppressWarnings("null")
    @Override
    @Nullable
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter arg1, MediaType arg2,
            Class<? extends HttpMessageConverter<?>> converterType, ServerHttpRequest arg4, ServerHttpResponse arg5) {
        boolean isAssignable = MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
        if (isAssignable) {
            if (body instanceof BaseResponse) {
                return body;
            } else if (body == null) {
                return new BaseResponse(0, "OK");
            } else {
                return new AppResponse<>(0, "OK", body);
            }
        } else {
            return new BaseResponse(0, "OK");
        }
    }

    @SuppressWarnings("null")
    @Override
    public boolean supports(MethodParameter returnType,
            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

}
