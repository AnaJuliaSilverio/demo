package org.example.repositories;

import net.bytebuddy.dynamic.DynamicType;
import org.example.infra.DAO;
import org.example.model.Person;

import java.util.List;
import java.util.Optional;

public class PersonRepository {
    private DAO dao;
    public PersonRepository(DAO dao) {
        this.dao = dao;
    }

    public void creatPerson(Person person){
        dao.addPerson(person);
    }
    public Optional<Person> findyPersonById(Long id){
        return dao.findPersonById(id);
    }
    public List<Person> getAllPerson(){
        return dao.getAllPerson();
    }
}
