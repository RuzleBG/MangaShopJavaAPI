package com.soosy.mangaapi.Exception;

public class MangaNotFoundExcpetion extends RuntimeException {
    public MangaNotFoundExcpetion(String message){
        super(message);
    }
    public MangaNotFoundExcpetion(String message, Throwable throwable){
        super(message,throwable);
    }
}
