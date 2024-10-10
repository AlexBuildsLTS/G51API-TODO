package se.alex.lexicon.g51todoapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOView;
import se.alex.lexicon.g51todoapi.service.PersonService;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOForm;


import java.util.List;
@Validated
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDTOView> createPerson(@Validated @RequestBody PersonDTOForm personDTOForm) {
        PersonDTOView personDTOView = personService.createPerson(personDTOForm);
        return new ResponseEntity<>(personDTOView, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PersonDTOView> getPersonById(@PathVariable Long id) {
        PersonDTOView personDTOView = personService.getPersonById(id);
        return personDTOView != null ? new ResponseEntity<>(personDTOView, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTOView>> getAllPersons() {
        List<PersonDTOView> persons;
        persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
