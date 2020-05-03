package com.test.springboottest;

import javax.persistence.*;

@Entity
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int tId;
    @Column
    private int bId;
    @Column
    private int sId;
    @Column
    private String bType;
    @Column
    private String sType;
    @Column
    private int tAmount;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public int gettAmount() {
        return tAmount;
    }

    public void settAmount(int tAmount) {
        this.tAmount = tAmount;
    }
}
