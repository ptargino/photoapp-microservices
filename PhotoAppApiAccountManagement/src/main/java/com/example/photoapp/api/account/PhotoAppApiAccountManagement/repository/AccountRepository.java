package com.example.photoapp.api.account.PhotoAppApiAccountManagement.repository;


import com.example.photoapp.api.account.PhotoAppApiAccountManagement.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

public interface AccountRepository extends ReactiveCrudRepository<Account, String> {

    Flux<Account> findByCustomerId(String customerId);

}
