package com.tutorial.service.impl;

import com.tutorial.domain.Person;
import com.tutorial.service.PersonService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 6/22/12
 * Time: 10:33 PM
 * To change this template use File | GradeLuluss | File Templates.
 */
@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Person person) {
        sessionFactory.getCurrentSession().saveOrUpdate(person);
    }

    @Override
    public Person getPerson(Long id) {
        return (Person) sessionFactory.getCurrentSession().get(Person.class,id);
    }

    @Override
    public List<Person> getAllPerson() {
        return sessionFactory.getCurrentSession().createQuery("from Person p order by p.id").list();
    }

    @Override
    public void removePerson(Person person) {
        sessionFactory.getCurrentSession().delete(person);
    }


}
