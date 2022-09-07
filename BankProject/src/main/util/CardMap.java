package main.util;

import java.util.HashMap;
import java.util.Map;

import main.services.Account;
import main.services.Card;

public class CardMap {
	private CardMap() {
		
	}
	
	private static Map<Card, Account> cardMap = new HashMap<>();
	
	static Map<Card, Account> getCardMap(){
		return cardMap;
	}
}
