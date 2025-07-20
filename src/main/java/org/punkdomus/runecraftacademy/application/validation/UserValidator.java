package org.punkdomus.runecraftacademy.application.validation;
import org.punkdomus.runecraftacademy.data.models.User;

public class UserValidator implements Validator<User> {
    private String errorMessage;

    @Override

    public boolean isValid(User user) {
        if (user == null) {
            errorMessage = "User cannot be null.";
            return false;
        }
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            errorMessage = "User name cannot be empty.";
            return false;
        }
        if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errorMessage = "Invalid email format.";
            return false;
        }
        return true;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}