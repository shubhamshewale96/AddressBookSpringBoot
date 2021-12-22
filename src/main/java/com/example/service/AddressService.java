package com.example.service;

import com.example.Model.Address;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AddressService {
   private List<Address> address =new ArrayList<>(Arrays.asList());
   public List<Address>getAllAddressBook(){
       return address;
   }

    public void addAddress(Address add) {
        address.add(add);
    }

    public void updateAddress(Long id, Address addressUpdate) {
       for(int i= 0;i<address.size();i++){
           Address a = address.get(i);
           if (a.getId().equals(id)){
               address.set(i,addressUpdate);
           }
       }
    }
}
