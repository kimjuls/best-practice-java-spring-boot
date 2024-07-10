package com.kimjuls.best_practice_java_spring_boot.classes;

public class AppResponse<T> extends BaseResponse {
    private T body;

    public AppResponse(int code, String message, T body) {
        super(code, message);
        this.body = body;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
