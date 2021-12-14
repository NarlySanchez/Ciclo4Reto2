package com.reto_2.repository.crud;

import com.reto_2.model.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author nbsc1
 * Reto 2 Ciclo 4
 */
public interface CloneCrudRepository extends MongoRepository<Clone, Integer> {
}
