package com.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.Person;
import com.kafka.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public Person create(@RequestBody Person person) {
		Person p = personService.create(person);
		return p;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Person getPerson(@RequestParam String firstName) {
		return personService.getByFirstName(firstName);
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Person> getAll(){
		return personService.getAll();
	}
	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer age) {
		Person p = personService.update(firstName, lastName, age);
		return p.toString();
	}
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String delete(@RequestParam String firstName) {
		personService.delete(firstName);
		return "Deleted "+firstName;
	}
	@RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
	public String deleteAll() {
		personService.deleteAll();
		return "Deleted all records";
	}
}
