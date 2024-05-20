package com.esanchez.devel.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esanchez.devel.model.Person;
import com.esanchez.devel.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

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
}
