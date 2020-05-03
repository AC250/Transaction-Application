package com.test.springboottest.service;

import com.test.springboottest.Customer;
import com.test.springboottest.Repository.WholesalerRepository;
import com.test.springboottest.Transaction;
import com.test.springboottest.Wholesaler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.MessageHandler;
import java.util.ArrayList;

@Service
public class WholesalerService {
    @Autowired
    WholesalerRepository wRepo;

    public void saveWholesaler(Wholesaler wr){
        wRepo.save(wr);
    }

    public void delWholesaler(int id){
        wRepo.deleteById(id);
    }

    public Wholesaler getWholesaler(int id){
        return wRepo.findById(id).get();
    }

    public ArrayList<Wholesaler> showWholesalers(){
        ArrayList<Wholesaler> wslList = new ArrayList<>();
        wRepo.findAll().forEach(wholesaler1 -> wslList.add(wholesaler1));
        return wslList;
    }

    public void updateWholesaler(Wholesaler wr, int id){
        Wholesaler temp = new Wholesaler();
        temp = wRepo.findById(id).get();
        temp.setName(wr.getName());
        temp.setEmail(wr.getEmail());
        saveWholesaler(temp);
    }
}
