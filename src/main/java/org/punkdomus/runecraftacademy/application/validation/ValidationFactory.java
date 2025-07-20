package org.punkdomus.runecraftacademy.application.validation;

import org.punkdomus.runecraftacademy.data.models.User;

public class ValidationFactory {
    public static <T> Validator<T> getValidator(Class<T> type) {
        if (type.equals(String.class)) {
            return (Validator<T>) new PasswordValidator();
        } else if (type.equals(User.class)) {
            return (Validator<T>) new UserValidator();
        }
        throw new IllegalArgumentException("No validator found for type: " + type.getName());
    }
}