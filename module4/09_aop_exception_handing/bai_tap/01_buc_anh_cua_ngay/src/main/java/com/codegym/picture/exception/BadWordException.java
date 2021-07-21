package com.codegym.picture.exception;

public class BadWordException extends Exception{
    public BadWordException() {
        super("Input feedback contains bad words!!!");
    }
}
