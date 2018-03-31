package com.example.rynzler.literarum.exceptions;

/**
 * Created by rynzler on 29/03/18.
 */

public class DataAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public DataAlreadyExistsException() {
        super();
    }

    public DataAlreadyExistsException(String msg) {
        super(msg);
    }
}