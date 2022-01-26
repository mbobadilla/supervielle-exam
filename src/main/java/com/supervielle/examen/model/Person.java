package com.supervielle.examen.model;

import lombok.*;
import lombok.experimental.Accessors;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person implements Serializable {

    @EmbeddedId
    private PersonPk personPk;
    @NotEmpty(message = "First name is required")
    private String firstName;
    @NotEmpty(message = "Last name is required")
    private String lastName;


    public Person(PersonPk personPk, String firstName, String lastName) {
        this.personPk = personPk;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
