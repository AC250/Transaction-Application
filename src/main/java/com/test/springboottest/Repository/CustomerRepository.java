package com.test.springboottest.Repository;

import com.test.springboottest.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
