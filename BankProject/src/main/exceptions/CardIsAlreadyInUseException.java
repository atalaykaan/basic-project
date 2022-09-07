package main.exceptions;

import java.io.IOException;

public class CardIsAlreadyInUseException extends IOException {
	public CardIsAlreadyInUseException(String message) {
		super(message);
	}
}
