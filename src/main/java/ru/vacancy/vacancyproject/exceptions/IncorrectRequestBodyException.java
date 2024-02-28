package ru.vacancy.vacancyproject.exceptions;

/**
 * @author Alex Ukrainskyy
 */
public class IncorrectRequestBodyException extends Exception {
    public IncorrectRequestBodyException(String message) {
        super(message);
    }
}
