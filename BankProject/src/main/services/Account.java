package main.services;

import java.util.Map;

import main.actions.Action;
import main.actions.EFT;
import main.exceptions.*;
import main.util.IbanMap;


public class Account {
	String iban;
	double balance;
	private static Map<String, Account> ibanMap = IbanMap.getIbanMap();
	
	Account(String iban, double balance) throws IbanAlreadyExistsException {
		if(!ibanMap.containsKey(iban))
				ibanMap.put(iban, this);
		else
			throw new IbanAlreadyExistsException("An user of this IBAN already exists!");
		this.iban = iban;
		this.balance = balance;
	}
	
	public void action(Action action, double amount) {
		try {
			if(action instanceof EFT) {
				EFT EFTAction = (EFT) action;
				EFTAction.setSourceIban.accept(iban);
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
	
	public double getBalance() {
		return balance;
	}
	
}
