package com.tutorial.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: bahrie
 * Date: 7/16/12
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long id;
    
    @Column(name = "jurusan",nullable = false)
    private String name;

    @Column(name = "country",nullable = false)
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person() {
    }

    public Person(Long id) {
        this.id=id;
    }
}
