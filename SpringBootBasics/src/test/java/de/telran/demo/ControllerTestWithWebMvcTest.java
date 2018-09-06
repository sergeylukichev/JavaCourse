package de.telran.demo;

import de.telran.demo.model.Person;
import de.telran.demo.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ControllerTestWithWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonRepository personRepository;

    @Test
    public void testGetById() throws Exception {
        given(personRepository.findById(1))
                .willReturn(java.util.Optional.of(new Person("Sergey", "Lukichev", 40)));

        mvc.perform(get("/api/persons/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().json("{\"first_name\":\"Sergey\",\n" +
                "  \"last_name\":\"Lukichev\",\n" +
                "  \"age\":40}"));
    }

    @Test
    public void testHelloWorld() throws Exception {
        given(personRepository.hello())
                .willReturn("Hello!");

        mvc.perform(get("/api").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string("Hello!"));
    }
}
