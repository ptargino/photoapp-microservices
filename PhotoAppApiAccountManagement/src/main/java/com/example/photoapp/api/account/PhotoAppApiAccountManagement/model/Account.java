package com.example.photoapp.api.account.PhotoAppApiAccountManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@ToString
public class Account {

    @Id
    private String id;
    private String number;
    private String customerId;
    private int amount;

    public Account(String number, String customerId, int amount) {
        this.number = number;
        this.customerId = customerId;
        this.amount = amount;
    }

}