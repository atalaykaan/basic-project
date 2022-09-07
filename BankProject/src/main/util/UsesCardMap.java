package main.util;

import java.util.Map;

import main.services.Account;
import main.services.Card;

public interface UsesCardMap {
	Map<Card, Account> cardMap = CardMap.getCardMap();
}
