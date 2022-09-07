package main.actions;

import main.exceptions.InsufficientFundsException;	
import main.exceptions.InvalidIbanException;
import main.services.EFTServices;
import main.util.ChecksIfIbanExists;

public class EFT extends EFTServices implements Action, ChecksFunds, ChecksIfIbanExists{
	public EFT(String targetIban) {
		this.targetIban = targetIban;
	}
	
	@Override
	public double act(double balance, double amount) throws InsufficientFundsException, InvalidIbanException {
		if(sourceIban.equals(targetIban))
			throw new InvalidIbanException("You can't EFT to your own account!\n");
		description.accept(amount);
		
		if(!checkIfIbanExists.test(targetIban)) 
			throw new InvalidIbanException("The IBAN you entered is invalid!");
		else
			if(hasEnoughFunds.test(balance, amount * EFT_CHARGE + amount))
				ibanMap.get(targetIban).operation(new Deposit(), amount);
			else
				throw new InsufficientFundsException("Insufficient funds!");
		
		feesDescription.accept(amount);
		return balance -= (amount * EFT_CHARGE + amount);
	}
	
}
