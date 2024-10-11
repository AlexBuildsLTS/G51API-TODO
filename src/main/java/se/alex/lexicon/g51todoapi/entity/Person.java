package se.alex.lexicon.g51todoapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email; // Added email field

    @OneToOne
    @JoinColumn()
    private User user;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public Person(Long id) {
        this.id = id;
    }

    public void removeTask(Task task) { // Simplified removeTask method
        if (task != null && this.tasks.remove(task)) {
            task.setPerson(null);
        }
    }
}