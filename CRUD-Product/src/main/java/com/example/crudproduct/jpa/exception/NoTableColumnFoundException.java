package com.example.crudproduct.jpa.exception;

public class NoTableColumnFoundException extends RuntimeException{
    public NoTableColumnFoundException(String errorMessage){
        super(errorMessage);
    }
}
