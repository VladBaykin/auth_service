package com.baykin.auth_service.repository;

import org.springframework.data.repository.CrudRepository;
import com.baykin.auth_service.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
