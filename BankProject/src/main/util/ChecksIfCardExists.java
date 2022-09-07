package main.util;

import java.util.function.Predicate;
import main.services.Card;

public interface ChecksIfCardExists extends UsesCardMap{
	Predicate<Card> checkIfCardExists = card -> cardMap.containsKey(card);
}
