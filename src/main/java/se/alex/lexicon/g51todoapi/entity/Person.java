package se.alex.lexicon.g51todoapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.net.ProtocolFamily;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @OneToOne
    @JoinColumn()
    private User user;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    public Person( String name ) {
        this.name = name;
    }

    public Person ( Long id ) {
        this.id = id;
    }

    public static ProtocolFamily builder ( ) {
        return null;
    }

// --Commented out by Inspection START (10/10/24, 9:39 AM):
//    private void addTask( Task... tasks ) { // task1, task2
//        if (Objects.requireNonNull( tasks ).length == 0)
//            throw new IllegalArgumentException( "Tasks cannot be empty" );
//        for (Task task : tasks) {
//            this.tasks.add( task );
//            task.setPerson( this );
//        }
//    }
// --Commented out by Inspection STOP (10/10/24, 9:39 AM)

    private void removeTask ( ) {
        removeTask ( (Task[]) null );
    }

    private void removeTask ( Task... tasks ) {
        if (Objects.requireNonNull( tasks ).length == 0)
            throw new IllegalArgumentException( "Tasks cannot be empty" );
        for (Task task : tasks) {
            if (this.tasks.remove( task ) && task.getPerson() == this) {
                task.setPerson( null );
            }
        }
    }
}
