package com.tutorial.controller;

import com.tutorial.domain.Person;
import com.tutorial.service.PersonService;
import com.tutorial.service.editor.PersonEditor;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * User: latief
 * Date: 3/19/12
 * Time: 11:07 AM
 * To change this template use File | GradeLuluss | File Templates.
 */
@Controller
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    @Qualifier("personService")
    private PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(ModelMap model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.getAllPerson());
        return "person";
    }

    //For add and update person both
    @RequestMapping(method = RequestMethod.POST)
    public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, ModelMap modelMap){

        if (person == null) return "Gagal";
        if (bindingResult.hasErrors()) return "Gagal";

        try {
            personService.save(person);
            //return "Sukses";
        } catch (HibernateException e) {
            return "Gagal";
        }

        return "redirect:/person/persons";

    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") Long id){
        try {
            personService.removePerson(new Person(id));
        } catch (HibernateException e) {
            return "Gagal";
        }
        return "redirect:/person/persons";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("person", this.personService.getPerson(id));
        model.addAttribute("listPersons", this.personService.getAllPerson());
        return "person";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception{
        binder.registerCustomEditor(Person.class, new PersonEditor(personService));
    }
}
