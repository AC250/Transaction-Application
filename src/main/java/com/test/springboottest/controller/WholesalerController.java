package com.test.springboottest.controller;

import com.test.springboottest.Customer;
import com.test.springboottest.Transaction;
import com.test.springboottest.Wholesaler;
import com.test.springboottest.service.TransactionService;
import com.test.springboottest.service.WholesalerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.MessageHandler;
import java.util.ArrayList;

@RestController
public class WholesalerController {
    @Autowired
    WholesalerService wholesaler;

    @PostMapping("/wholesaler/add")
    private void addTransaction(@RequestBody Wholesaler ws){
        wholesaler.saveWholesaler(ws);
    }

    @DeleteMapping("/wholesaler/delete/{wId}")
    private void deleteWholesaler(@PathVariable("wId") int id){
        wholesaler.delWholesaler(id);
    }

    @GetMapping("/wholesaler")
    private ArrayList<Wholesaler> showAllWholesaler(){
        return wholesaler.showWholesalers();
    }

    @GetMapping("/wholesaler/{wId}")
    private Wholesaler showWholesaler(@PathVariable("wId") int id){
        return wholesaler.getWholesaler(id);
    }

    @PutMapping("/wholesaler/update/{wId}")
    private void updateWsl(@RequestBody Wholesaler wr, @PathVariable("wId") int id){
        wholesaler.updateWholesaler(wr,id);
    }
}
