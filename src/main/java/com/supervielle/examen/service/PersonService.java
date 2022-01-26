package com.supervielle.examen.service;

import com.supervielle.examen.model.Person;
import com.supervielle.examen.model.PersonPk;
import com.supervielle.examen.mvc.request.PersonRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PersonService {
    public Person createPerson(PersonRequest personRequest);
    public List<Person> getPersons(PersonRequest personRequest);
    public Person updatePerson(PersonRequest personRequest);
    public boolean deletePerson(PersonRequest personRequest);
}
