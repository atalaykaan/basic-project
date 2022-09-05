package main.util;

import java.util.HashMap;
import java.util.Map;

import main.services.Account;

public class IbanMap {
	private IbanMap() {
		
	}
	
	private static Map<String, Account> ibanMap = new HashMap<String, Account>();
	
	public static Map<String, Account> getIbanMap() {
		return ibanMap;
	}
	
}
