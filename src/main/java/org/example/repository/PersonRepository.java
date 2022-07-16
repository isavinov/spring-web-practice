package org.example.repository;

import org.example.domain.Person;

import java.util.Collection;

public interface PersonRepository {

    Collection<Person> findAll();

    void save(Person person);
}
