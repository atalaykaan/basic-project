package main.util;

import java.util.HashMap;
import java.util.Map;

import main.services.BankAccount;

public class IbanMap {
	private IbanMap() {
		
	}
	
	private static Map<String, BankAccount> ibanMap = new HashMap<String, BankAccount>();
	
	static Map<String, BankAccount> getIbanMap() {
		return ibanMap;
	}
	
}
