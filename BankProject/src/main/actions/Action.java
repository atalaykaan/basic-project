package main.actions;

import main.exceptions.InsufficientFundsException;
import main.exceptions.InvalidIbanException;

public interface Action {
	public double act(double balance, double amount) throws InsufficientFundsException, InvalidIbanException;
	
}
