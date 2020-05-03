package com.test.springboottest.service;

import com.test.springboottest.Repository.CustomerRepository;
import com.test.springboottest.Repository.RetailerRepository;
import com.test.springboottest.Repository.TransactionRepository;
import com.test.springboottest.Repository.WholesalerRepository;
import com.test.springboottest.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository tRepo;
    @Autowired
    WholesalerRepository wRepo;
    @Autowired
    RetailerRepository rRepo;
    @Autowired
    CustomerRepository cRepo;
    public void saveTransaction(Transaction tr){
        //Function returns 200 OK even when conditions not satisfied, but doesn't store value in table which is what we want.
        //doesnt throw error, just ignores the input.
        boolean flag = true;
        // checking if the buyer or seller id exists or not
        switch(tr.getbType().toLowerCase()){
            case "customer" : if(!cRepo.existsById(tr.getbId())) flag = false; break;
            case "wholesaler" : if(!wRepo.existsById(tr.getbId())) flag = false; break;
            case "retailer" : if(!rRepo.existsById(tr.getbId())) flag = false; break;
        }
        switch(tr.getsType().toLowerCase()){
            case "customer" : if(!cRepo.existsById(tr.getsId())) flag = false; break;
            case "wholesaler" : if(!wRepo.existsById(tr.getsId())) flag = false; break;
            case "retailer" : if(!rRepo.existsById(tr.getsId())) flag = false; break;
        }

        //checking conditions for buyer type and seller type
        if((tr.getbType().equalsIgnoreCase("retailer")&&tr.getsType().equalsIgnoreCase("customer"))||
                (tr.getsType().equalsIgnoreCase("retailer")&&tr.getbType().equalsIgnoreCase("customer"))
        ||(tr.getbType().equalsIgnoreCase("retailer")&&tr.getsType().equalsIgnoreCase("wholesaler"))||
                (tr.getsType().equalsIgnoreCase("retailer")&&tr.getbType().equalsIgnoreCase("wholesaler"))
        &&flag==true) {

            tRepo.save(tr);
        }
    }

    public void delTransaction(int id){
        tRepo.deleteById(id);
    }

    public Transaction getTransaction(int id){
        return tRepo.findById(id).get();
    }

    public ArrayList<Transaction> showTransactions(){
        ArrayList<Transaction> trxnList = new ArrayList<Transaction>();
        tRepo.findAll().forEach(transaction1 -> trxnList.add(transaction1));
        return trxnList;
    }

    public void updateTransaction(Transaction tr, int id){
        Transaction temp = new Transaction();
        temp = tRepo.findById(id).get();
        temp.setbType(tr.getbType());
        temp.setsType(tr.getsType());
        temp.setbId(tr.getbId());
        temp.setsId(tr.getsId());
        temp.settAmount(tr.gettAmount());
        saveTransaction(temp);
    }
}
