package main.util;

import java.util.Map;
import main.services.BankAccount;

public interface UsesIbanMap {
	Map<String, BankAccount> ibanMap = IbanMap.getIbanMap();
	
}
