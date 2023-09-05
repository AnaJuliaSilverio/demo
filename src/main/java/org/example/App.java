package org.example;

import org.example.infra.DAO;
import org.example.model.Person;
import org.example.repositories.PersonRepository;
import org.example.service.PersonService;

import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        DAO dao = new DAO();
        PersonRepository personRepository = new PersonRepository(dao);
        PersonService personService = new PersonService(personRepository);

        while (true){
            System.out.println("Digite a opcao desejada:\n1-Criar nova pessoa\n2-Procurar pessoa pelo id\n3-Buscar todas as pessoas\n4-Sair");
            switch (sc.next()) {
                case "1" -> {
                    Person person = inputPerson();
                    personService.createPerson(person);
                }
                case "2" -> {
                    System.out.println("Digite o id:");
                    Long id = sc.nextLong();
                    System.out.println(personService.findPersonById(id));
                }
                case "3" -> {
                    List<Person> people = personService.getAllPerson();
                    people.forEach(System.out::println);
                }
                case "4" -> {
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida");
            }
        }

    }
    public static Person inputPerson(){
        Scanner sc = new Scanner(System.in);
        Person person = new Person();
        System.out.println("Digite seu cpf:");
        person.setCpf(sc.next());
        System.out.println("Digite seu nome:");
        person.setNome(sc.next());
        System.out.println("Digite seu email:");
        person.setEmail(sc.next());

        return person;
    }
}
