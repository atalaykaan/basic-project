package main.services;

public class CreditCard extends Card {
	private double credits;
	private double limit;
	
	CreditCard(String number, Account owner){
		super(number, owner);
	}
}
