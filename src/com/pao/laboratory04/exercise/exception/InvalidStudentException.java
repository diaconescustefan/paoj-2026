package com.pao.laboratory04.exercise.exception;

/**
 * Exceptie custom - Student invalid
 */
public class InvalidStudentException extends RuntimeException {
    
    public InvalidStudentException(String message) {
        super(message);
    }
    
    public InvalidStudentException(String message, Throwable cause) {
        super(message, cause);
    }
}
