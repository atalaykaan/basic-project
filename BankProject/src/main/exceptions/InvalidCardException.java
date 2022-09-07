package main.exceptions;

import java.io.IOException;

public class InvalidCardException extends IOException{
	public InvalidCardException(String message) {
		super(message);
	}
}
