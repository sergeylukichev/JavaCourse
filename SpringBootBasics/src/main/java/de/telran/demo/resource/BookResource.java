package de.telran.demo.resource;

import de.telran.demo.exception.ResourceNotFoundException;
import de.telran.demo.model.Book;
import de.telran.demo.repository.BookRepository;
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
@RequestMapping("/api/books")
public class BookResource {

    private final BookRepository bookRepository;

    public BookResource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    List<Book> all() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    Book getById(@PathVariable long id) throws Exception {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found", "Book", id));
    }

    @GetMapping("/find/{author}")
    List<Book> findByAuthor(@PathVariable String author) {
        return bookRepository.findByAuthor(author);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Book create(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }


}
