package com.gdjs.gold.response;

import org.springframework.http.HttpStatus;

/**
 * @Author wyg
 * @Date 2019/9/23 14:05
 */
public class ResponseBean<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseBean() {
    }

    public ResponseBean(Integer code, String message) {
        this(code,message,null);
    }

    public ResponseBean(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseBean success(){
        return new ResponseBean(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase());
    }

    public static <T> ResponseBean success(T data){
        return new ResponseBean(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),data);
    }

    public static ResponseBean fail(){
        return new ResponseBean(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    public static <T> ResponseBean fail(T data){
        return new ResponseBean(HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),data);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
