package com.test.springboottest.controller;

import com.test.springboottest.Transaction;
import com.test.springboottest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transaction;

    @PostMapping("/transaction/add")
    private void addTransaction(@RequestBody Transaction ts){
        transaction.saveTransaction(ts);
    }

    @DeleteMapping("/transaction/delete/{tId}")
    private void deleteTransaction(@PathVariable("tId") int id){
        transaction.delTransaction(id);
    }

    @GetMapping("/transaction")
    private ArrayList<Transaction> showAllTransaction(){
        return transaction.showTransactions();
    }

    @GetMapping("/transaction/{tId}")
    private Transaction showTransaction(@PathVariable("tId") int id){
        return transaction.getTransaction(id);
    }

    @PutMapping("/transaction/update/{tId}")
    private void updateTrxn(@RequestBody Transaction tr,@PathVariable("tId") int id){
        transaction.updateTransaction(tr, id);
    }
}
