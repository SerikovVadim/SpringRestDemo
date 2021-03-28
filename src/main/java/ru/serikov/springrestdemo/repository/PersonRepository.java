package ru.serikov.springrestdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.serikov.springrestdemo.entity.Person;

/**
 * Repository interface for {@link Person} class.
 *
 * @author Vadim Serikov
 * @version 1.0
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByPassport(String passport);
}
