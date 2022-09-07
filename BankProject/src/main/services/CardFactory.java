package main.services;

public class CardFactory {
	public static Card generateNewCard(Account owner) {
		
		Long number = new Long(2351493700000000L + (long)(100000000 * Math.random()));
		
		return new CreditCard(number.toString(), owner);
	}
}
