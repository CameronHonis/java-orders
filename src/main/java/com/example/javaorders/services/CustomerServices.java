package com.example.javaorders.services;

import com.example.javaorders.models.Customer;

import java.util.List;

public interface CustomerServices {
    List<Customer> findAllCustomers();
    Customer findCustomerById(long id);
}
