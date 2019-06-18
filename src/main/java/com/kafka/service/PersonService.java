package com.kafka.service;

import java.util.List;

import java.lang.RuntimeException;

import org.bson.types.ObjectId;
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
		if(!person.getId().isEmpty()) {
			person.setId(ObjectId.get().toString());
		}
		
	    if(getByName(person.getName()) != null) {
	    	throw new RuntimeException("Já existe esse nome em nosso banco de dados");
	    }
	    
		return personRepository.save(person);
	}
	
	//Retrieve operation
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	
	public Person getByName(String name) {
		return personRepository.findByName(name);
	}
	
	//Update operation
	public Person update(String name, Person person) {
		Person p = personRepository.findByName(name);
		p = person;
		
		return personRepository.save(p);
	}
	//Delete operation
	public void delete(String name) {
		Person p = personRepository.findByName(name);
		personRepository.delete(p);
	}
}
