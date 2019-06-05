package com.kafka.service;

import java.util.List;

import java.lang.RuntimeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.model.Person;
import com.kafka.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	//Create operation
	public Person create(Person person) {
		Person p = person;
	    if(getByFirstName(p.getFirstName()) != null) {
	    	throw new RuntimeException("Já existe esse nome em nosso banco de dados");
	    }
		return personRepository.save(p);
	}
	//Retrieve operation
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	public Person getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}
	//Update operation
	public Person update(String firstName, String lastName, Integer age) {
		Person p = personRepository.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return personRepository.save(p);
	}
	//Delete operation
	public void deleteAll() {
		personRepository.deleteAll();
	}
	public void delete(String firstName) {
		Person p = personRepository.findByFirstName(firstName);
		personRepository.delete(p);
	}
}
