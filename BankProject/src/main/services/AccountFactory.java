package main.services;

public class AccountFactory {
	public static Account createNewAccount(String iban, double balance) {
		return new Account(iban, balance);
	}
	
}
