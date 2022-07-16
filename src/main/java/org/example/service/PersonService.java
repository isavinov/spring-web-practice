package org.example.service;

import org.example.domain.Person;

import java.util.Collection;

public interface PersonService {

    Collection<Person> getAllPersons();

    void createPerson(Person person);

    Person getPerson(Long id);
}
