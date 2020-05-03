package com.test.springboottest.service;

import com.test.springboottest.Customer;
import com.test.springboottest.Repository.CustomerRepository;
import com.test.springboottest.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository cRepo;

    public void saveCustomer(Customer cr){
        cRepo.save(cr);
    }

    public void delCustomer(int id){
        cRepo.deleteById(id);
    }

    public Customer getCustomer(int id){
        return cRepo.findById(id).get();
    }

    public ArrayList<Customer> showCustomers(){
        ArrayList<Customer> custList = new ArrayList<Customer>();
        cRepo.findAll().forEach(Customer1->custList.add(Customer1));
        return custList;
    }

    public void updateCustomer(Customer cr, int id){
        Customer temp= new Customer();
        temp = cRepo.findById(id).get();
        temp.setName(cr.getName());
        temp.setEmail(cr.getEmail());
        saveCustomer(temp);
    }
}
