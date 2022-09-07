package main.exceptions;

import java.io.IOException;

public class AtmIsBusyException extends IOException{
	public AtmIsBusyException(String message){
		super(message);
	}
}
