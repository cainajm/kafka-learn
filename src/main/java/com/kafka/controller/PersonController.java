package com.kafka.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.Person;
import com.kafka.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/client")
@Api(value = "Person", description = "Client user")
@CrossOrigin
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	//Metodo para criar um novo usuario
	@ApiOperation(value = "Client create")
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public Person create(@Valid @RequestBody Person person) {
		personService.create(person);
		return null;
	}
	
	//Metodo para buscar um usuario pelo nome
	@ApiOperation(value = "Client get by name")
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Person getPerson(@RequestParam String name) {
		return personService.getByName(name);
	}
	
	//Metodo para buscar todos os usuarios
	@ApiOperation(value = "Client get all")
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Person> getAll(){
		return personService.getAll();
	}
	
	//Metodo para alterar um usuario
	@ApiOperation(value = "Client update by name")
	@RequestMapping(value = "/update", method = RequestMethod.PATCH, produces = "application/json")
	public String update(@RequestParam String name, @Valid @RequestBody Person person) {
		personService.update(name, person);
		return null;
	}
	
	//Metodo para deleter um usuario
	@ApiOperation(value = "Client delete by name")
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String delete(@RequestParam String name) {
		personService.delete(name);
		return null;
	}
}
