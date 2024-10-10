package se.alex.lexicon.g51todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.alex.lexicon.g51todoapi.entity.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);
    List<Person> findByEmail(String email);
}
