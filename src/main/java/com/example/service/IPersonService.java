package com.example.service;

import com.example.Model.Person;

import java.util.List;

public interface IPersonService {

    List<Person> getAllPerson();

    Person getPersonById(int id);

    Person savePerson(Person person);

    Person updatePerson(int id, Person person);

    void deletePerson(int id);
}