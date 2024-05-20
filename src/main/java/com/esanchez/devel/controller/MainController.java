package com.esanchez.devel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
