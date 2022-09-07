package main.exceptions;

import java.io.IOException;

public class FindAnAtmException extends IOException{
	public FindAnAtmException(String message) {
		super(message);
	}
}
