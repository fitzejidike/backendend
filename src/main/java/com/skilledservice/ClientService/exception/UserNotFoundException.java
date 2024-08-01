package com.skilledservice.ClientService.exception;

public class UserNotFoundException extends ClientBaseException {
    public UserNotFoundException(String message){
        super(message);
    }
}
