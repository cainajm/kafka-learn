package com.kafka.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
	@Id
	String id;
	String name;
	String email;
	String telePhone;
	String cellPhone;
	Integer age;
	
	public Person() {
        super();
    }
	
	public Person(String name, String email, String telePhone, String cellPhone, Integer age) {
		this.name = name;
		this.email = email;
		this.telePhone = telePhone;
		this.cellPhone = cellPhone;
		this.age = age;
	}

	public final String getId() {
		return id;
	}

	public final String getName() {
		return name;
	}

	public final String getEmail() {
		return email;
	}

	public final String getTelePhone() {
		return telePhone;
	}

	public final String getCellPhone() {
		return cellPhone;
	}

	public final Integer getAge() {
		return age;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
		
}
