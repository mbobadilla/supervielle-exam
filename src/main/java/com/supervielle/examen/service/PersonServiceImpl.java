package com.supervielle.examen.service;
import com.supervielle.examen.model.Person;
import com.supervielle.examen.model.PersonPk;
import com.supervielle.examen.mvc.request.PersonRequest;
import com.supervielle.examen.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    PersonRepository personRepository;


    @Override
    public Person createPerson(PersonRequest personRequest) {
        return personRepository.save(getPerson(personRequest));
    }

    @Override
    public List<Person> getPersons(PersonRequest personRequest) {
        return personRepository.findAll();
    }

    @Override
    public Person updatePerson(PersonRequest personRequest) {
        Optional<Person> person =personRepository.findByPersonPk(personRequest.getPersonPK());
        if (person.get()!=null){
            Person pNew= getPerson(personRequest);
            pNew.setPersonPk(person.get().getPersonPk());
            return personRepository.save(pNew);

        }
        return null;
    }

    @Override
    public boolean deletePerson(PersonRequest personRequest) {
        Optional<Person> person =personRepository.findByPersonPk(personRequest.getPersonPK());
        if (person.get()!=null){
             personRepository.delete(person.get());
             return true;
        }
        return false;

    }
    private Person getPerson(PersonRequest personRequest){
        PersonPk personPk = personRequest.getPersonPK();
        return new Person(personPk, personRequest.getFirstName(), personRequest.getLastName());
    }
}
