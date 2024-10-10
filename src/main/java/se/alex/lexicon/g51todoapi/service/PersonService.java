package se.alex.lexicon.g51todoapi.service;

import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOView;

import java.util.List;

public interface PersonService {
    PersonDTOView createPerson(PersonDTOForm personDTOForm);
    PersonDTOView getPersonById(Long id);
    List<PersonDTOView> getAllPersons();

    List<PersonDTOView> getPersonsByName ( String name );

    List<PersonDTOView> getPersonsByEmail( String email);
    PersonDTOView updatePerson(PersonDTOView personDTOView);
}
