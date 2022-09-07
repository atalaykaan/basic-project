package main.services;

import java.util.function.Consumer;

public abstract class IbanServices {
	protected String sourceIban;
	protected Consumer<String> setSourceIban = iban -> sourceIban = iban;
}
