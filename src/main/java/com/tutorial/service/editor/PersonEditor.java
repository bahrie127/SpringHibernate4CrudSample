package com.tutorial.service.editor;


import com.tutorial.domain.Person;
import com.tutorial.service.PersonService;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: Latief
 * Date: 6/27/11
 * Time: 9:28 AM
 * To change this template use File | GradeLuluss | File Templates.
 */
public class PersonEditor extends PropertyEditorSupport {

    private PersonService personService;

    public PersonEditor(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            long id = Long.parseLong(text);

            Person result = personService.getPerson(id);

            if (result != null) {
                setValue(result);
            } else {
                throw new IllegalArgumentException("Person with id " + id + " not Found!");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public String getAsText() {
        if (getValue() != null) {
            Person result = (Person) getValue();
            return result.getId() + "";
        } else {
            return "";
        }
    }
}