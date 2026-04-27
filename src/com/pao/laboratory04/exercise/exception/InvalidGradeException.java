package com.pao.laboratory04.exercise.exception;

/**
 * Exceptie custom - Nota invalida
 */
public class InvalidGradeException extends RuntimeException {
    
    public InvalidGradeException(String message) {
        super(message);
    }
    
    public InvalidGradeException(String message, Throwable cause) {
        super(message, cause);
    }
}
