package se.alex.lexicon.g51todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTO;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOView;
import se.alex.lexicon.g51todoapi.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDTOView> createPerson(@RequestBody PersonDTOForm personDTOForm) {
        System.out.println("form = " + personDTOForm);
        PersonDTOView createdPerson = personService.createPerson(personDTOForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTOView>> getAllPersons() {
        List<PersonDTOView> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTOView> getPersonById(@PathVariable Long id) {
        PersonDTOView person = personService.getPersonById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PersonDTOView>> getPersonByName(@PathVariable String name) {
        List<PersonDTOView> persons = personService.getPersonsByName(name);
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<PersonDTOView>> getPersonByEmail(@PathVariable String email) {
        List<PersonDTOView> persons = personService.getPersonsByEmail(email);
        return ResponseEntity.ok(persons);
    }

    @PutMapping
    public ResponseEntity< PersonDTOView> updatePerson( @RequestBody PersonDTO personDTO) {
        PersonDTOView updatedPerson = personService.updatePerson(personDTO);
        return ResponseEntity.ok(updatedPerson);
    }
}