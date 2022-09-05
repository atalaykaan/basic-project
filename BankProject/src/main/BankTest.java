package main;

import main.actions.Deposit;
import main.actions.EFT;
import main.actions.Withdraw;
import main.services.Account;
import main.services.AccountFactory;

public class BankTest {
	public static void main(String[] args) {
		Account ac1 = AccountFactory.createNewAccount("1111", 5000);
		Account ac2 = AccountFactory.createNewAccount("2222", 50000);
		
		ac1.action(new Withdraw(), 2500);
		ac1.action(new Deposit(), 5000);
		ac2.action(new EFT("1111"), 40000);
		ac2.action(new EFT("2222"), 500);
		
		System.out.println("ac1 balance: " + ac1.getBalance());
		System.out.println("ac2 balance: " + ac2.getBalance());
	}
	
}
