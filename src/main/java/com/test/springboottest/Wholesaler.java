package com.test.springboottest;

import javax.persistence.*;

@Entity
@Table
public class Wholesaler {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wId;
    @Column
    private String name;
    @Column(unique = true)//email should be unique
    private String email;
    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
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
