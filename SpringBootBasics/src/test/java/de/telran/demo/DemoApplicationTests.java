package de.telran.demo;

import de.telran.demo.model.Person;
import de.telran.demo.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testCreatePerson() throws Exception {
        mvc.perform(post("/api/").content("{\"first_name\":\"Sergey\",\n" +
                "  \"last_name\":\"Lukichev\",\n" +
                "  \"age\":40}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andExpect(content().json("{\"first_name\":\"Sergey\",\n" +
                "  \"last_name\":\"Lukichev\",\n" +
                "  \"age\":40}"));
    }

    @Test
    public void testFindById() throws Exception {

        personRepository.addPerson(new Person("Sergey", "Lukichev", 40));

        mvc.perform(get("/api/persons/0").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().json("{\"first_name\":\"Sergey\",\n" +
                "  \"last_name\":\"Lukichev\",\n" +
                "  \"age\":40}"));
    }

    @Test
    public void testHelloWorld() throws Exception {
        mvc.perform(get("/api/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }
}

