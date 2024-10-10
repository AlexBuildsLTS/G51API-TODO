package se.alex.lexicon.g51todoapi.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@Table(name = "user_roles")
public class Role {

    private final String roleUser;
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @ManyToOne
    @JoinColumn(name = "user_email", referencedColumnName = "email", nullable = false)
    private User user;
    @ManyToOne
    private Role role;

    @Setter
    @Getter
    @Id
    private String id;

    public Role ( String roleUser ) {
        this.roleUser = roleUser;
    }

    public Role ( Long id ) {

        roleUser = "ADMIN";
        role = new Role( id );
    }

    public Role ( ) {

        roleUser = String.valueOf ( id );
    }

    public String getName ( ) {
        return "";
    }
}