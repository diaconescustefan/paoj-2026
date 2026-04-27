package com.pao.laboratory04.exercise.exception;

/**
 * Exceptie custom - Student nu gasit
 */
public class StudentNotFoundException extends RuntimeException {
    
    public StudentNotFoundException(String message) {
        super(message);
    }
    
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
