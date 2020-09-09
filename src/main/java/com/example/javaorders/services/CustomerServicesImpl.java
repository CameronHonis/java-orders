package com.example.javaorders.services;

import com.example.javaorders.models.Customer;
import com.example.javaorders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerServices")
public class CustomerServicesImpl implements CustomerServices{
    @Autowired
    private CustomersRepository custrepos;

    @Override
    public List<Customer> findAllCustomers(){
        List<Customer> c = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(c::add);
        return c;
    }

    @Override
    public Customer findCustomerById(long id){
        return custrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found!"));
    }


}
