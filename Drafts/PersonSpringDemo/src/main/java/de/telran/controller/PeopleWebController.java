package de.telran.controller;


import de.telran.model.Person;
import de.telran.service.PeopleService;
import de.telran.webmodel.PeopleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeopleWebController {

    @Autowired
    PeopleService service;


    @GetMapping("/people")
    public String getIndexForm(Model model) {
        model.addAttribute("peopleForm", new PeopleForm());
        model.addAttribute("people", service.getPeople());
        return "index";
    }

    @PostMapping("addPerson")
    public String addPerson(Model model, PeopleForm form) {
        Person person = new Person(form.getFirstName(), form.getLastName());
        service.addPerson(person);

        model.addAttribute("people", service.getPeople());

        return "index";
    }
}
