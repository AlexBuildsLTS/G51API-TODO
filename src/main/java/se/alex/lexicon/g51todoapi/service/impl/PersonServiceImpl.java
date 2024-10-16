package se.alex.lexicon.g51todoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.alex.lexicon.g51todoapi.converter.PersonConverter;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTO;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOView;
import se.alex.lexicon.g51todoapi.entity.Person;
import se.alex.lexicon.g51todoapi.exception.DataNotFoundException;
import se.alex.lexicon.g51todoapi.repository.PersonRepository;
import se.alex.lexicon.g51todoapi.service.PersonService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonConverter personConverter;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }

    @Override
    public PersonDTOView createPerson(PersonDTOForm personDTOForm) {
        Person person = personConverter.toPersonEntity(personDTOForm);
        Person savedPerson = personRepository.save(person);
        return personConverter.toPersonDTOView(savedPerson);
    }

    @Override
    public PersonDTOView getPersonById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Person not found with ID: " + id));
        return personConverter.toPersonDTOView(person);
    }

    @Override
    public List<PersonDTOView> getAllPersons() {
        return personRepository.findAll().stream()
                .map(personConverter::toPersonDTOView)
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDTOView> getPersonsByName(String name) {
        return personRepository.findByNameContaining(name).stream()
                .map(personConverter::toPersonDTOView)
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDTOView> getPersonsByEmail(String email) {
        return personRepository.findByEmailContaining(email).stream()
                .map(personConverter::toPersonDTOView)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTOView updatePerson(PersonDTO personDTO) {
        Person person = personRepository.findById(personDTO.getId())
                .orElseThrow(() -> new DataNotFoundException("Person not found with ID: " + personDTO.getId()));
        personConverter.updateFromPersonDTO(personDTO, person);
        Person updatedPerson = personRepository.save(person);
        return personConverter.toPersonDTOView(updatedPerson);
    }
}