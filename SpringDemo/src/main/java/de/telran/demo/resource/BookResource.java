package de.telran.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.telran.demo.Book;
import de.telran.demo.PersonService;

@RestController
@RequestMapping("/api/books")
public class BookResource {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public String hello() {
		return personService.sayHello();
	}

	@GetMapping("/morebooks")
	public Book hello2() {
		return new Book("Petrov", "Kotlin");
	}
}
