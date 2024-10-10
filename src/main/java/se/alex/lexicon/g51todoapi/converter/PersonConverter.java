package se.alex.lexicon.g51todoapi.converter;

import org.springframework.stereotype.Component;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOView;
import se.alex.lexicon.g51todoapi.entity.Person;

@Component
public class PersonConverter {


    public PersonDTOView toPersonDTOView(Person person) {
        if (person == null) {
            return null; // If the input is null, return null to avoid NullPointerExceptions.
        }

        return PersonDTOView.builder()
                .id(person.getId())
                .name(person.getName())
                .email(person.getUser() != null ? person.getUser().getEmail() : null)
                .tasks(null) // If there are tasks, add proper conversion here.
                .build();
    }



    public void updatePersonEntityFromDTO(PersonDTOView personDTOView, Person person) {
        if (personDTOView == null || person == null) {
            return;
        }

        person.setName(personDTOView.getName());
        // You can add more fields as needed, such as email if applicable.
    }

    public PersonDTOForm newPersonDTOForm ( ) {
        return new PersonDTOForm( );
    }

    public Person toPersonDTOView ( se.alex.lexicon.g51todoapi.domain.dto.PersonDTOForm personDTOForm ) {
        return null;
    }

    public Person toPersonEntity ( se.alex.lexicon.g51todoapi.domain.dto.PersonDTOForm personDTOForm ) {
        return null;
    }

    public class PersonDTOForm {
        private PersonDTOForm ( ) {
        }
    }
}
