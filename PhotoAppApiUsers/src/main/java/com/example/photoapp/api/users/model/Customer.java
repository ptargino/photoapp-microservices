package com.example.photoapp.api.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private int age;
	@Transient
	private List<Account> accounts;

	public Customer(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Customer(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public void addAccount(Account account) {
		this.accounts.add(account);
	}

}
