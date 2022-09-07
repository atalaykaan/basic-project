package main.exceptions;

import java.io.IOException;

public class AlreadyLoggedOutException extends IOException{
	public AlreadyLoggedOutException(String message) {
		super(message);
	}
}
