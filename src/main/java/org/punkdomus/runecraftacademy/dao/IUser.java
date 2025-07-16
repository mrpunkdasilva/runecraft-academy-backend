package org.punkdomus.runecraftacademy.dao;

import org.punkdomus.runecraftacademy.models.User;
import org.springframework.data.repository.CrudRepository;

public interface IUser extends CrudRepository<User, Integer> {
}
