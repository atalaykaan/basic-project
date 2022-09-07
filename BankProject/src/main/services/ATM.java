package main.services;

import main.actions.Action;	
import main.exceptions.AtmIsBusyException;
import main.exceptions.InvalidCardException;
import main.util.ChecksIfCardExists;

public class ATM implements ChecksIfCardExists {
	private ATMStatus currentStatus = ATMStatus.NO_CARDS;
	private Card insertedCard;
	private Account user;
	private Account loggedAccount;
	
	ATM consumeCard(Card insertedCard, Account user) throws InvalidCardException {
		try {
		if(currentStatus != ATMStatus.NO_CARDS)
			throw new AtmIsBusyException("This ATM is busy right now!\n");
		this.user = user;
		this.insertedCard = insertedCard;
		currentStatus = currentStatus.proceed();
		validateCard();
		}
		catch(AtmIsBusyException e) {
			System.out.println(e.getMessage());
		}
		return this;
	}
	
	private void validateCard() throws InvalidCardException {

		if(!checkIfCardExists.test(insertedCard)) {
			ejectCard();
			throw new InvalidCardException("The card you inserted is invalid!");
		}
		else if(user != cardMap.get(insertedCard)) {
			ejectCard();
			throw new InvalidCardException("This card doesn't belong to you!");
		}
		else
			logIn();
	}
	
	private void logIn() {
		loggedAccount = cardMap.get(insertedCard);
		currentStatus = currentStatus.proceed();
		System.out.println("Successfully logged in!\n");
	}
	
	void operate(Action action, double amount) {
		if(currentStatus != ATMStatus.CARD_INSERTED)
			System.out.println("You must insert a card before you can do any actions!\n");
		else
			((BankAccount)loggedAccount).changeBalance(action, amount);
	}
	
	void logOut() {
		System.out.println("Logging out...\n");
		loggedAccount = null;
		ejectCard();
	}
	
	private void ejectCard() {
		while(currentStatus != ATMStatus.NO_CARDS)
			currentStatus = currentStatus.precede();
		insertedCard.eject();
		insertedCard = null;
		user = null;
	}
	
//	private BooleanSupplier isTheCardInserted = () -> currentStatus == ATMStatus.CARD_INSERTED;
}