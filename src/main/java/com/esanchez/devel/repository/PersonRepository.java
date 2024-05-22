package com.esanchez.devel.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.esanchez.devel.model.Person;

public interface PersonRepository extends MongoRepository<Person, String>{

	Optional<Person> findByName(String name);
}
