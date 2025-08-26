package com.example.Controllers;


import com.example.Entity.Address;
import com.example.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addRepository;

    @GetMapping("/getAddresses")
    public List<Address> getAddresses() {
        return addRepository.findAll();
    }
}
