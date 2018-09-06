package de.telran.demo.repository;

import de.telran.demo.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PersonRepository {

    private List<Person> persons = new ArrayList<>();

    public Person addPerson(Person person) {
        persons.add(person);
        return person;
    }

    public Optional<Person> findById(int id) {
        if(id < persons.size()) {
            return Optional.of(persons.get(id));
        } else {
            return Optional.empty();
        }

    }

    public List<Person> getAll() {
        return persons;
    }

    public String hello() {
        return "Hello World!";
    }

}
