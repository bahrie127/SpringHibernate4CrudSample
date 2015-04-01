package com.tutorial.service;

import com.tutorial.domain.Person;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/22/12
 * Time: 10:33 PM
 * To change this template use File | GradeLuluss | File Templates.
 */
public interface PersonService {

    public void save(Person person);

    public Person getPerson(Long id);

    public List<Person> getAllPerson();

    public void removePerson(Person person);
}
