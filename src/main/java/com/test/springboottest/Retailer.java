package com.test.springboottest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

@Entity
@Table
public class Retailer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rId;
    @Column
    private String name;
    @Column(unique = true) //email should be unique
    private String email;
    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
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
