package com.esanchez.devel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esanchez.devel.model.Person;
import com.esanchez.devel.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	private static final Logger logger = LogManager.getLogger(PersonServiceImpl.class);
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public List<Person> listAll() {
		return personRepository.findAll();
	}
	
	@Override
	public void insert(Person person) {
		person.setCreated(LocalDateTime.now());
		personRepository.insert(person);
	}
	
	@Override
	public void addFriend(String name, Person friend) {
		
		Optional<Person> person = personRepository.findByName(name);
		
		if (person.isPresent()) {
			person.get().getFriends().add(friend);
			personRepository.save(person.get());
		} else {
			logger.error("Person not found with name '{}'", name);
		}
	}
}
