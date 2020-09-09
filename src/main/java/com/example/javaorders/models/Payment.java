package com.example.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentid;

    private String type;

    public Payment(){

    }

    public Payment(String type){
        this.type = type;
    }


}
