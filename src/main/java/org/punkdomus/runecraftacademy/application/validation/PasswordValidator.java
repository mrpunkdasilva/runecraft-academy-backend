package org.punkdomus.runecraftacademy.application.validation;

public class PasswordValidator implements Validator<String> {
    private String errorMessage;

    @Override
    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            errorMessage = "Password must be at least 8 characters long.";
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            errorMessage = "Password must contain at least one uppercase letter.";
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            errorMessage = "Password must contain at least one lowercase letter.";
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            errorMessage = "Password must contain at least one digit.";
            return false;
        }
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) {
            errorMessage = "Password must contain at least one special character.";
            return false;
        }
        return true;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}