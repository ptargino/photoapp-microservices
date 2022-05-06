package com.example.photoapp.api.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Account {

	private String id;
	private String number;
	private int amount;

	public Account(String id, String number, int amount) {
		this.id = id;
		this.number = number;
		this.amount = amount;
	}
}
