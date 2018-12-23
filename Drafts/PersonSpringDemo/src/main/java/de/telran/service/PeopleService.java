package de.telran.service;

import de.telran.model.Person;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PeopleService {

    private List<Person> people = new LinkedList<>();

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person getPersonById(int id) {
        return people.get(id);
    }

}
