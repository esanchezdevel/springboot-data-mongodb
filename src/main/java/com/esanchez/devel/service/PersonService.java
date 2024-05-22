package com.esanchez.devel.service;

import java.util.List;

import com.esanchez.devel.model.Person;

public interface PersonService {

	List<Person> listAll();
	
	void insert(Person person);
	
	void addFriend(String name, Person friend);
	
	void deletePerson(String name);
}
