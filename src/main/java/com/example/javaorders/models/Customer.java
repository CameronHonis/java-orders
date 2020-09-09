package com.example.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;

    private String custcity;

    private String custname;

    private String grade;

    private double openingamt;

    private double outstandingamt;

    private double paymentamt;

    private String phone;

    private double receiveamt;

    private String workingarea;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnoreProperties(value = "customers", allowSetters = true)
    private Agent agent;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "customer", allowSetters = true)
    private List<Order> orders = new ArrayList<>();

    public Customer(){

    }

    public Customer(
            String custname,
            String custcity,
            String workingarea,
            String custcountry,
            String grade,
            double openingamt,
            double receiveamt,
            double paymentamt,
            double outstandingamt,
            String phone,
            Agent agent) {
        this.custcity = custcity;
        this.custname = custname;
        this.grade = grade;
        this.openingamt = openingamt;
        this.outstandingamt = outstandingamt;
        this.paymentamt = paymentamt;
        this.phone = phone;
        this.receiveamt = receiveamt;
        this.workingarea = workingarea;
        this.agent = agent;
    }
}
