package com.example.controller;

import com.example.*;
import com.example.entity.Address;
import com.example.repository.AddressRepository;
import com.example.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addRepository;

    @GetMapping("/getAddress")
    public List<Address> getEmployees(){
        return addRepository.findAll();
    }
}