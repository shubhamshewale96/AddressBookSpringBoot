package com.example.controller;

import com.example.Model.Person;
import com.example.convertor.EntityToDTOConvertor;
import com.example.dto.PersonDTO;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    PersonService personService;

    @Autowired
    EntityToDTOConvertor convertor;

    @GetMapping("/get")
    public ResponseEntity<List<PersonDTO>> getAllPerson() {
        List<Person> allPerson = personService.getAllPerson();
        List<PersonDTO> dtoList = convertor.entityToDTO(allPerson);
        return new ResponseEntity<List<PersonDTO>>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/get/{eId}")
    public ResponseEntity<PersonDTO> gePersonById(@PathVariable("eId") int eId) {
        Person person = personService.getPersonById(eId);
        PersonDTO personDTO = convertor.entityToDTO(person);
        return new ResponseEntity<PersonDTO>(personDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PersonDTO> addPerson(@Valid @RequestBody PersonDTO personDTO) {
        Person person = convertor.dtoToEntity(personDTO);
        Person savedPerson = personService.savePerson(person);
        PersonDTO persondto = convertor.entityToDTO(savedPerson);
        return new ResponseEntity<PersonDTO>(persondto, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable("id") int id, @Valid @RequestBody PersonDTO personDto) {
        Person person = convertor.dtoToEntity(personDto);
        Person updatedPerson = personService.updatePerson(id, person);
        PersonDTO persondto = convertor.entityToDTO(updatedPerson);
        return new ResponseEntity<PersonDTO>(persondto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") int id) {
        personService.deletePerson(id);
        return new ResponseEntity<String>("Data deleted for id : " + id, HttpStatus.OK);
    }
}