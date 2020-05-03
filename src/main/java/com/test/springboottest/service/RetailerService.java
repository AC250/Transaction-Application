package com.test.springboottest.service;

import com.test.springboottest.Customer;
import com.test.springboottest.Repository.RetailerRepository;
import com.test.springboottest.Retailer;
import com.test.springboottest.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RetailerService {
    @Autowired
    RetailerRepository rRepo;
    public void saveRetailer(Retailer rt){
        rRepo.save(rt);
    }

    public void delRetailer(int id){
        rRepo.deleteById(id);
    }

    public Retailer getRetailer(int id){
        return rRepo.findById(id).get();
    }

    public ArrayList<Retailer> showRetailers(){
        ArrayList<Retailer> rtrList= new ArrayList<Retailer>();
        rRepo.findAll().forEach(retailer1 -> rtrList.add(retailer1));
        return rtrList;
    }

    public void updateRetailer(Retailer rt, int id){
        Retailer temp = new Retailer();
        temp = rRepo.findById(id).get();
        temp.setName(rt.getName());
        temp.setEmail(rt.getEmail());
        saveRetailer(temp); //call to function at line 14
    }
}
