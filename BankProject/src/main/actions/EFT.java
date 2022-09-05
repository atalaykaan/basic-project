package main.actions;

import java.util.Map;
import java.util.function.Consumer;

import main.exceptions.InsufficientFundsException;
import main.exceptions.InvalidIbanException;
import main.services.Account;
import main.util.IbanMap;

public class EFT implements Action, ChecksFunds {
	protected String sourceIban;
	protected String targetIban;
	
	protected Map<String, Account> ibanList = IbanMap.getIbanMap();
	
	protected static final double EFT_CHARGE = 0.02;
	
	public EFT(String targetIban) {
		this.targetIban = targetIban;
	}
	
	public Consumer<String> setSourceIban = (iban) -> sourceIban = iban;
	
	@Override
	public double act(double balance, double amount) throws InsufficientFundsException, InvalidIbanException {
		if(sourceIban.equals(targetIban))
			throw new InvalidIbanException("You can't EFT to your own account!\n");
		System.out.println("Transacting " + amount + "TL to the bank account of IBAN number: " + targetIban + "...");
		System.out.println("This action costs 2% of the entered amount in fees.\n");
		
		if(!ibanList.containsKey(targetIban)) 
			throw new InvalidIbanException("The IBAN you entered is invalid!");
		else
			if(hasEnoughFunds.test(balance, amount * EFT_CHARGE + amount))
				ibanList.get(targetIban).action(new Deposit(), amount);
			else
				throw new InsufficientFundsException("Insufficient funds!");
		
		System.out.println("This transaction has cost " + amount * EFT_CHARGE + "TL in fees.");
		return balance -= (amount * EFT_CHARGE + amount);
	}
	
}
