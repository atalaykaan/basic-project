package main.services;

import main.actions.Action;
import main.exceptions.*;
import main.util.ChecksIfIbanExists;
import main.util.UsesCardMap;


public class BankAccount implements ChecksIfIbanExists, UsesCardMap, Account{
	private String iban;
	private double balance;
	private ATM occupiedAtm;
	
	BankAccount(String iban, double balance) throws IbanAlreadyExistsException {
		if(!checkIfIbanExists.test(iban))
				ibanMap.put(iban, this);
		else
			throw new IbanAlreadyExistsException("An user of this IBAN already exists!\n");
		this.iban = iban;
		this.balance = balance;
	}
	
	public void insertCardToAtm(Card card, ATM atm) {
		try {
			card.insert(atm);
			occupiedAtm = atm.consumeCard(card, this);
		}
		catch(InvalidCardException e) {
			System.out.println(e.getMessage() + " Logging out...\n");
			if(occupiedAtm == atm)
				occupiedAtm = null;
		}
		catch(CardIsAlreadyInUseException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void operation(Action action, double amount) {
		try {
			if(occupiedAtm == null)
				throw new FindAnAtmException("You must use an ATM to make transactions!\n");
			occupiedAtm.operate(action, amount);			
		}
		catch(FindAnAtmException e) {
			System.out.println(e.getMessage());
		}
	}
	
	void changeBalance(Action action, double amount) {
		try {
			if(action instanceof IbanServices) {
				IbanServices IbanAction = (IbanServices) action;
				IbanAction.setSourceIban.accept(iban);
			}
			balance = action.act(balance, amount);
			System.out.println("Transaction successul!\n");
		}
		catch(InvalidIbanException e) {
			System.out.println(e.getMessage());
		}
		catch(InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void logOutOfAtm() {
		try {
			if(occupiedAtm == null) 
				throw new AlreadyLoggedOutException("You need to be logged in to log out!\n");
			occupiedAtm.logOut();
			occupiedAtm = null;
		}
		catch(AlreadyLoggedOutException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
}
