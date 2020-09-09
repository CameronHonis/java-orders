package com.example.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    @Column(unique = true, nullable = false)
    private String agentname;

    private double commission;

    private String country;

    private String phone;

    private String workingarea;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "agent", allowSetters = true)
    private List<Customer> customers = new ArrayList<>();

    public Agent(){

    }

    public Agent(
            String agentname,
            String country,
            double commission,
            String phone,
            String workingarea
    ) {
        this.agentname = agentname;
        this.commission = commission;
        this.country = country;
        this.phone = phone;
        this.workingarea = workingarea;
    }
}
