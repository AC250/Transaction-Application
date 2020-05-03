package com.test.springboottest.controller;

import com.test.springboottest.Customer;
import com.test.springboottest.Transaction;
import com.test.springboottest.service.CustomerService;
import com.test.springboottest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customer;

    @PostMapping("/customer/add")
    private void addCustomer(@RequestBody Customer cr){
        customer.saveCustomer(cr);
    }

    @DeleteMapping("/customer/delete/{cId}")
    private void deleteCustomer(@PathVariable("cId") int id){
        customer.delCustomer(id);
    }

    @GetMapping("/customer")
    private ArrayList<Customer> showAllCustomers(){
        return customer.showCustomers();
    }

    @GetMapping("/customer/{cId}")
    private Customer showCustomer(@PathVariable("cId") int id){
        return customer.getCustomer(id);
    }

    @PutMapping("/customer/update/{cId}")
    private void updateCust(@RequestBody Customer cr, @PathVariable("cId") int id){
        customer.updateCustomer(cr,id);
    }
}
