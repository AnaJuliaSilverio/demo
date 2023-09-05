package org.example.service;

import org.example.model.Person;
import org.example.repositories.PersonRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public void createPerson(Person person){
        personRepository.creatPerson(person);
        System.out.println(person.getNome()+" inserido(a) com sucesso!");
    }
    public Person findPersonById(Long id){
        return personRepository.findyPersonById(id).orElseThrow(EntityNotFoundException::new);
    }
    public List<Person> getAllPerson(){
        return personRepository.getAllPerson();
    }
}
