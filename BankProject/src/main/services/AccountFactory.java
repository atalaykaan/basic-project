package main.services;

import main.exceptions.NegativeBalanceException;

public class AccountFactory {
	public static Account createNewAccount(String iban, double balance) {
		if(balance < 0)
			throw new NegativeBalanceException("Invalid balance! Balance can't be negative.");
		return new BankAccount(iban, balance);
	}
	
}
