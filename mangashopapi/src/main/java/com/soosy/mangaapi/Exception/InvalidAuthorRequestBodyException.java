package com.soosy.mangaapi.Exception;

public class InvalidAuthorRequestBodyException extends RuntimeException{
    public InvalidAuthorRequestBodyException(String message){
        super(message);
    }

    public InvalidAuthorRequestBodyException(String message, Throwable cause){
        super(message, cause);
    }
}
