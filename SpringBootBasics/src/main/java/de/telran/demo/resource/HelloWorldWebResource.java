package de.telran.demo.resource;

import de.telran.demo.exception.ResourceNotFoundException;
import de.telran.demo.model.Person;
import de.telran.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloWorldWebResource {

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public String getHelloWorld() {
        return personRepository.hello();
    }

    @GetMapping("/persons")
    public List<Person> getPerson() {
        return personRepository.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        Person person1 = personRepository.addPerson(person);
        return person1;
    }

    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found", "Person", (long)id));
    }
}
