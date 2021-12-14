package com.reto_2.repository.crud;

import com.reto_2.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author nbsc1
 * Reto 2 Ciclo 4
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
}
