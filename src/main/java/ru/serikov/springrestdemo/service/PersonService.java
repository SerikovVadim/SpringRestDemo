package ru.serikov.springrestdemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.serikov.springrestdemo.entity.Person;
import ru.serikov.springrestdemo.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

/**
 * Main service class of application.
 *
 * @author Vadim Serikov
 * @version 1.0
 */
@Service
public class PersonService {

    private final PersonRepository personRepository;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Optional<Person> findById(long id) {
        return personRepository.findById(id);
    }

    public boolean existsById(long id) {
        return !personRepository.existsById(id);
    }

    public List<Person> findByAll() {
        return personRepository.findAll();
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void delete(long id) {
        personRepository.deleteById(id);
    }

    public Person findByPassport(String passport) {
        return personRepository.findByPassport(passport);
    }
}
