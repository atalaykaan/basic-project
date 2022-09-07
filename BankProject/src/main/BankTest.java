package main;

import main.actions.*;
import main.services.ATM;
import main.services.Account;
import main.services.AccountFactory;
import main.services.Card;
import main.services.CardFactory;

public class BankTest {
	public static void main(String[] args) {
		Account ac1 = AccountFactory.createNewAccount("1111", 5000);
		Account ac2 = AccountFactory.createNewAccount("2222", 50000);
		
		Card cc1 = CardFactory.generateNewCard(ac1);
		Card cc2 = CardFactory.generateNewCard(ac2);
		Card cc3 = CardFactory.generateNewCard(ac1);
		
		ATM atm1 = new ATM();
		ATM atm2 = new ATM();
		
		ac1.insertCardToAtm(cc1, atm1);
		ac1.operation(new Withdraw(), 3000);
		ac1.insertCardToAtm(cc3, atm1);
		ac1.insertCardToAtm(cc1, atm2);
		ac1.insertCardToAtm(cc2, atm2);
		ac1.operation(new Deposit(), 8888);
		ac2.insertCardToAtm(cc2, atm2);
		ac2.operation(new Withdraw(), 10000);
		
		System.out.println(ac1.getBalance());
		System.out.println(ac2.getBalance());
	}
	
}
