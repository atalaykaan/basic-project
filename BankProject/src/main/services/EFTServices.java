package main.services;

import java.util.function.DoubleConsumer;

public abstract class EFTServices extends IbanServices{
	protected String targetIban;
	
	protected static final double EFT_CHARGE = 0.02;
	
	protected DoubleConsumer description = amount -> System.out.println (
			"Transacting " + amount + "TL to the bank account of IBAN number: " + targetIban + "...\n"
			+ "This action costs 2% of the entered amount in fees.\n"
		);
	protected DoubleConsumer feesDescription = amount -> System.out.println (
			"This transaction has cost " + amount * EFT_CHARGE + "TL in fees."
		);
}
