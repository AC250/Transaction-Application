package com.test.springboottest.Repository;

import com.test.springboottest.Retailer;
import org.springframework.data.repository.CrudRepository;

public interface RetailerRepository extends CrudRepository<Retailer, Integer> {
}
