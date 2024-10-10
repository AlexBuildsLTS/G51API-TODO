package se.alex.lexicon.g51todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.alex.lexicon.g51todoapi.entity.Person;

import java.util.Arrays;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    default Arrays findByEmail ( String email ) {
        return null;
    }
}
