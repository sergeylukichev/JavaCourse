package de.telran.controller;


import de.telran.model.Person;
import de.telran.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeopleResource {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/people")
    public List<Person> getPeople() {
        return peopleService.getPeople();
    }

    @GetMapping("/people/{id}")
    public Person getPersonById(@PathVariable int id) {
        return peopleService.getPersonById(id);
    }

    @PostMapping("/people")
    public void addPerson(@RequestBody Person person) {
        peopleService.addPerson(person);
    }


}
