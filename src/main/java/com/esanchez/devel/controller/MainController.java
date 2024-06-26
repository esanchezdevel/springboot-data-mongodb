package com.esanchez.devel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esanchez.devel.model.Person;
import com.esanchez.devel.service.PersonService;

@RestController
@RequestMapping("/mongodb")
public class MainController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/people")
	public ResponseEntity<List<Person>> getPeople() {
		return ResponseEntity.ok(personService.listAll());
	}
	
	@PostMapping("/person")
	public ResponseEntity<?> insertPerson(@RequestBody Person person) {
		
		personService.insert(person);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/person/{name}/add/friend")
	public ResponseEntity<?> addFriend(@PathVariable("name") String name, @RequestBody Person friend) {
		
		personService.addFriend(name, friend);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/person/{name}")
	public ResponseEntity<?> deletePerson(@PathVariable("name") String name) {
		
		personService.deletePerson(name);
		
		return ResponseEntity.ok().build();
	}
}
