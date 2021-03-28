package ru.serikov.springrestdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.serikov.springrestdemo.entity.Person;
import ru.serikov.springrestdemo.service.PersonService;

import java.util.Optional;

/**
 * REST controller for {@link Person} connected requests.
 *
 * @author Vadim Serikov
 * @version 1.0
 */
@Controller
@RequestMapping("/api/v1/persons/")
public class PersonRestControllerV1 {

    private final PersonService personService;

    @Autowired
    public PersonRestControllerV1(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping({"{id}"})
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Person> person = personService.findById(id);
        return person.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        personService.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }


    @PutMapping()
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        personService.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Person> deletePerson(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
