package com.test.springboottest;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO) //so that same id value doesnt occur for different tables(wholesaler, retailer etc)
    private int cId;
    @Column
    private String name;
    @Column(unique = true) //email should be a unique value
    private String email;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
