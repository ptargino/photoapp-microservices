package com.example.photoapp.api.users.repository;

import com.example.photoapp.api.users.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {
	
}
