package com.test.springboottest.controller;

import com.test.springboottest.Customer;
import com.test.springboottest.Retailer;
import com.test.springboottest.Transaction;
import com.test.springboottest.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RetailerController {
    @Autowired
    RetailerService retailer;

    @PostMapping("/retailer/add")
    private void addRetailer(@RequestBody Retailer rs){
        retailer.saveRetailer(rs);
    }

    @GetMapping("/retailer/delete/{rId}")
    private void deleteRetailer(@PathVariable("rId") int id){
        retailer.delRetailer(id);
    }

    @GetMapping("/retailer")
    private ArrayList<Retailer> showAllRetailers(){
        return retailer.showRetailers();
    }

    @GetMapping("/retailer/{rId}")
    private Retailer showRetailer(@PathVariable("rId") int id){
        return retailer.getRetailer(id);
    }

    @PutMapping("/retailer/update/{rId}")
    private void updateRet(@RequestBody Retailer rt, @PathVariable("rId") int id){
        retailer.updateRetailer(rt,id);
    }
}
