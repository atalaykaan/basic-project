package main.services;

public enum ATMStatus {
	NO_CARDS, PROCESSING, CARD_INSERTED;
	
	ATMStatus proceed() {
		ATMStatus nextProcess = null;
		if(this == NO_CARDS)
			nextProcess = PROCESSING;
		else
			nextProcess = CARD_INSERTED;
		return nextProcess;
	}
	
	ATMStatus precede() {
		ATMStatus previousProcess;
		if(this == CARD_INSERTED)
			previousProcess = PROCESSING;
		else
			previousProcess = NO_CARDS;
		return previousProcess;
	}
	
}
