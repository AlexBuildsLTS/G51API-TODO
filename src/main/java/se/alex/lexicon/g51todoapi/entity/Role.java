package se.alex.lexicon.g51todoapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String User;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    // Constructors
    public Role(String roleName) {
        this.User = roleName;
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role() {

    }

    public String getName ( ) {
        return "";
    }
}
