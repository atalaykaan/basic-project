package main.services;

import main.actions.Action;

public interface Account {
	public void operation(Action action, double balance);
	
	public void insertCardToAtm(Card card, ATM atm);
	
	public void logOutOfAtm();
	
	public double getBalance();
	
}
