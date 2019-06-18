package com.kafka.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kafka.model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
	public Person findByName(String name);
	public List<Person> findByAge(Integer age);
}
