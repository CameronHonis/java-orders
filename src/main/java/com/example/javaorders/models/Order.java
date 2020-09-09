package com.example.javaorders.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;

    private double advanceamount;

    private double ordamount;

    private String orderdescription;

    @ManyToOne
    @JoinColumn(name = "custcode")
    private Customer customer;

    @ManyToMany()
    @JoinTable(name = "orderpayments",
        joinColumns = @JoinColumn(name = "ordnum"),
        inverseJoinColumns = @JoinColumn(name = "paymentid"))
    private Set<Payment> payments = new HashSet<>();

    public Order(){

    }

    public Order(
            double ordamount,
            double advanceamount,
            Customer customer,
            String orderdescription){
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.customer = customer;
        this.orderdescription = orderdescription;
    }

    public void addPayments(Payment payment){
        payments.add(payment);
    }
}
