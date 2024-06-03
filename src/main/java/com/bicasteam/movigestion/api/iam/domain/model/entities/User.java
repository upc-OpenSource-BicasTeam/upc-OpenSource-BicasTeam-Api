package com.bicasteam.movigestion.api.iam.domain.model.entities;

import com.bicasteam.movigestion.api.iam.domain.model.commands.CreateUserCommand;
import jakarta.persistence.*;
import lombok.Getter;

//import javax.persistence.*;

@Getter
@Entity
public class User extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

    private String type;

    public User() {
    }

    public User(String name, String lastName, String email, String password, String type) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User(CreateUserCommand command) {
        this.name = command.name();
        this.lastName = command.lastName();
        this.email = command.email();
        this.password = command.password();
        this.type = command.type();
    }
}