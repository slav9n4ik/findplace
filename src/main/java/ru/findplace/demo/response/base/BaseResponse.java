package ru.findplace.demo.response.base;

public class BaseResponse implements Response{

    private final String status;
    private final Integer code;

    public BaseResponse(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getReasonPhrase() {
        return null;
    }

    @Override
    public Response setReasonPhrase(String reasonPhrase) {
        return null;
    }
}

