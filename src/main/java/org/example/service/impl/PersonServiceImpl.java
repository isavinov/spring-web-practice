package org.example.service.impl;

import org.example.domain.Person;
import org.example.repository.PersonRepository;
import org.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Collection<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person getPerson(Long id) {
        return null;
    }
}
