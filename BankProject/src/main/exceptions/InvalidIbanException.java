package main.exceptions;

import java.io.IOException;

public class InvalidIbanException extends IOException {
	public InvalidIbanException(String message) {
		super(message);
	}
	
}
