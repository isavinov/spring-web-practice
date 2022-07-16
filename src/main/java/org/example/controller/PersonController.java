package org.example.controller;

import org.example.domain.Person;
import org.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.util.Collection;


@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public Collection<Person> getPersons() {
        return personService.getAllPersons();

    }

    @GetMapping
    @RequestMapping("/{id}")
    public Person getPerson(Long id) {
        return personService.getPerson(id);

    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void savePerson(@RequestBody @Valid Person person) {
        personService.createPerson(person);
    }

    @PostMapping("/upload")
    public void upload(@RequestParam("file")MultipartFile file){
        System.out.println("!!!!!");
    }
}
