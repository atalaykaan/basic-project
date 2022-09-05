package main.actions;

import main.exceptions.InsufficientFundsException;
import main.exceptions.InvalidIbanException;

public class Deposit implements Action {
	@Override
	public double act(double balance, double amount) throws InsufficientFundsException, InvalidIbanException {
		System.out.println("Depositing " + amount + "TL...");
		balance += amount;
		return balance;
		
	}
}
