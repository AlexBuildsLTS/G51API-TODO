package se.alex.lexicon.g51todoapi.service;

import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOView;

import java.util.List;

public interface PersonService< P > {

    default PersonDTOView createPerson ( PersonDTOForm personDTOForm ) {
        return null;
    }

    PersonDTOView createPerson ( Object o );

    PersonDTOView getPersonById( Long id);

    List<PersonDTOView> getPersonsByName(String name);

    List<PersonDTOView> getPersonsByEmail(String email);

    PersonDTOView updatePerson(PersonDTOView personDTOView);

    class PersonDTOForm {
    }
}
