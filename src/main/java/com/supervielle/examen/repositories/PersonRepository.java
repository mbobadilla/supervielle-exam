package com.supervielle.examen.repositories;

import com.supervielle.examen.model.Person;
import com.supervielle.examen.model.PersonPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByPersonPk(PersonPk personPk);
    List<Person>findAll();

}
