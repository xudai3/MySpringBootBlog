package com.xd.myspringbootblog.response;

import java.io.Serializable;

public class Response{

    private Integer code;
    private String message;
    private Object data;

    public Response() {}

    public Response(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Response success(){
        setStatusCode(StatusCode.SUCCESS);
        return this;
    }

    public Response success(Object data){
        setStatusCode(StatusCode.SUCCESS);
        this.data = data;
        return this;
    }

    public Response failure(StatusCode statusCode, String message){
        setStatusCode(statusCode);
        setMessage(message);
        return this;
    }

    public Response failure(StatusCode statusCode){
        setStatusCode(statusCode);
        return this;
    }

    public Response failure(StatusCode statusCode, Object data){
        setStatusCode(statusCode);
        this.data = data;
        return this;
    }

    public void setStatusCode(StatusCode statusCode){
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    @Override
    public String toString(){
        return "Response:{" +
                "code=" + this.code +
                ", message='" + this.message + '\'' +
                ", data={" + data.toString() + "}" +
                "}";
    }

}
