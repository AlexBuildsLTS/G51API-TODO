package se.alex.lexicon.g51todoapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;

    public Task ( LocalDate deadline ) {
        this.deadline = deadline;
    }

    @ManyToOne(fetch = LAZY)
    @JoinColumn()
    private Person person;

    public Task( String title, String description, LocalDate deadline, Person person ) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.person = person;
    }

    public Task( String title, String description, LocalDate deadline, boolean done, Person person ) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.person = person;
    }

    public Task( String title, String description, LocalDate deadline ) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }
}
