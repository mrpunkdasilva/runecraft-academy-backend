package org.punkdomus.runecraftacademy.application.validation;

public interface Validator<T> {
    boolean isValid(T data);
    String getErrorMessage();
}