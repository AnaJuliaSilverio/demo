package org.example.infra;

import org.example.model.Person;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class DAO {

    public void addPerson(Person person){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            entityManager.persist(person);

            entityTransaction.commit();
        }
        catch (Exception exception) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            exception.printStackTrace();
        }
        finally {
            entityManager.close();
        }
    }

    public Optional<Person> findPersonById(Long id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return Optional.ofNullable(entityManager.find(Person.class, id));
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
    public List<Person> getAllPerson(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM Person p", Person.class);
            return query.getResultList();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
