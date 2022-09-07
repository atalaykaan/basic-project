package main.services;

import main.exceptions.CardIsAlreadyInUseException;
import main.util.ChecksIfCardExists;

public abstract class Card implements ChecksIfCardExists{
	String number;
	private Account owner;
	private ATM insertedAtm;
	
	Card(String number, Account owner) {
		if(!checkIfCardExists.test(this))
			cardMap.put(this, owner);
		this.number = number;
		this.owner = owner;
	}
	
	void insert(ATM insertedAtm) throws CardIsAlreadyInUseException{
		if(this.insertedAtm != null)
			throw new CardIsAlreadyInUseException("This card is already in use!\n");
		else
			this.insertedAtm = insertedAtm;
	}
	
	void eject() {
		insertedAtm = null;
	}
	
	String getNumber() {
		return number;
	}
}
