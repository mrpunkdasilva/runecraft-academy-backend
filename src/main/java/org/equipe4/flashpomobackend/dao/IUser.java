package org.equipe4.flashpomobackend.dao;

import org.equipe4.flashpomobackend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface IUser extends CrudRepository<User, Integer> {
}
