package com.exception;

public class UserNameNotExistException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserNameNotExistException(String message){
        super(message);
    }
}
