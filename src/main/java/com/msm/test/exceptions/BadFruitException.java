package com.msm.test.exceptions;

/**
 * Created by asbhui on 01/08/2016.
 */
public class BadFruitException extends Throwable {

    public BadFruitException() {
    }

    public BadFruitException(String message) {
        super(message);
    }
}
