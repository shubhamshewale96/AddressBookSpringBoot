package com.example.controller;

import com.example.Model.Address;
import com.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping(value = {"", "/", "/greet"})
    public String greeting() {
        return "Welcome To Addressbook.";
    }

    @GetMapping("/AddressBook")
    public List<Address>  getAllAddreaaBook(){
        return addressService.getAllAddressBook();
        }
    @PostMapping("/add")
    public void addAddress(@RequestBody Address addressAdd){
        addressService.addAddress(addressAdd);

    }
    @PutMapping("/update/{id}")
    public void update(@RequestBody Address addressUpdate,@PathVariable Long id){
        addressService.updateAddress(id,addressUpdate);
    }
}