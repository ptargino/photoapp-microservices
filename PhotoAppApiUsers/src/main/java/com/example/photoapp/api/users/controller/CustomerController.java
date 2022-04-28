package com.example.photoapp.api.users.controller;

import com.example.photoapp.api.users.model.Account;
import com.example.photoapp.api.users.model.Customer;
import com.example.photoapp.api.users.repository.CustomerRepository;
import com.example.photoapp.api.users.utils.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerRepository repository;
	@Autowired
    private WebClient.Builder webClientBuilder;

	@GetMapping("/{id}")
	public Mono<Customer> findById(@PathVariable("id") String id) {
		LOGGER.info("findById: id={}", id);
		return repository.findById(id);
	}

	@GetMapping
	public Flux<Customer> findAll() {
		LOGGER.info("findAll");
		return repository.findAll();
	}

	@GetMapping("/{id}/with-accounts")
	public Mono<Customer> findByIdWithAccounts(@PathVariable("id") String id) {
		LOGGER.info("findByIdWithAccounts: id={}", id);
		Flux<Account> accounts = webClientBuilder.build().get().uri("http://account-service/customer/{customer}", id).retrieve().bodyToFlux(Account.class);
		return accounts
				.collectList()
				.map(a -> new Customer(a))
				.mergeWith(repository.findById(id))
				.collectList()
				.map(CustomerMapper::map);
	}

	@PostMapping
	public Mono<Customer> create(@RequestBody Customer customer) {
		LOGGER.info("create: {}", customer);
		return repository.save(customer);
	}
	
}
