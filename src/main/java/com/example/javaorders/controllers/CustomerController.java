package com.example.javaorders.controllers;

import com.example.javaorders.models.Customer;
import com.example.javaorders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerServices customerServices;

    @GetMapping(value = "/customers", produces = "application/json")
    public ResponseEntity<?> listAllCustomers(){
        List<Customer> c = customerServices.findAllCustomers();
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{custId}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long custId){
        Customer c = customerServices.findCustomerById(custId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
}
