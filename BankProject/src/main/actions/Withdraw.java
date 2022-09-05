package main.actions;

import main.exceptions.InsufficientFundsException;
import main.exceptions.InvalidIbanException;

public class Withdraw implements Action, ChecksFunds {
	@Override
	public double act(double balance, double amount) throws InsufficientFundsException, InvalidIbanException {
		System.out.println("Withdrawing " + amount + "TL...");
		if (hasEnoughFunds.test(balance, amount))
			balance -= amount;
		else
			throw new InsufficientFundsException("Insufficient funds!");
		return balance;
		
	}
}
