package main.exceptions;

public class IbanAlreadyExistsException extends RuntimeException {
	public IbanAlreadyExistsException(String message){
		super(message);
	}
	
}
