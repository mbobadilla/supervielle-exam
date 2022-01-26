package com.supervielle.examen.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class PersonPk implements Serializable {
    public PersonPk() {
    }

    public PersonPk(String documentType, String documentNumber, String country, String genre) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.country = country;
        this.genre = genre;
    }

    private String documentType;
    private String documentNumber;
    private String country;
    private String genre;

}
