package se.alex.lexicon.g51todoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.alex.lexicon.g51todoapi.converter.PersonConverter;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOView;
import se.alex.lexicon.g51todoapi.entity.Person;
import se.alex.lexicon.g51todoapi.exception.DataNotFoundException;
import se.alex.lexicon.g51todoapi.repository.PersonRepository;
import se.alex.lexicon.g51todoapi.service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService<PersonDTOView> {

    private final PersonRepository personRepository;
    private final PersonConverter personConverter;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }

    @Override
    public PersonDTOView createPerson ( Object o ) {
        // Implementation required: Convert and save the Person entity.
        return null; // Placeholder for future implementation.
    }

    @Override
    public PersonDTOView getPersonById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Person with ID " + id + " not found."));
        return personConverter.toPersonDTOView(person);
    }

    @Override
    public List<PersonDTOView> getPersonsByName(String name) {
        return personRepository.findByName(name).stream()
                .map(personConverter::toPersonDTOView)
                .collect(Collectors.toList());
    }

    /**
     */
    @Override
    public List < PersonDTOView > getPersonsByEmail ( String email ) {
        return List.of( );
    }

    @Override
    public PersonDTOView createPerson ( PersonDTOForm personDTOForm ) {
        return PersonService.super.createPerson( personDTOForm );
    }

    @Override
    public PersonDTOView updatePerson(PersonDTOView personDTOView) {
        // Placeholder for updating an existing person.
        return null; // Implement the update logic.
    }
}
