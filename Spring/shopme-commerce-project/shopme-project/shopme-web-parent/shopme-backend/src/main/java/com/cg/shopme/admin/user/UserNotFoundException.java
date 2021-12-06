package com.cg.shopme.admin.user;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String s) {
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException() {
    }
}
