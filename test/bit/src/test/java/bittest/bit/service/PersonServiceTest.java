package bittest.bit.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class PersonServiceTest {

    @Autowired
    PersonService personService;

    @Test
    public void addPet() {

        personService.addPet(1L, "pup");

    }
}