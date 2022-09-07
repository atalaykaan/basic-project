package main.util;

import java.util.function.Predicate;

public interface ChecksIfIbanExists extends UsesIbanMap{
	Predicate<String> checkIfIbanExists = iban -> ibanMap.containsKey(iban);
}
