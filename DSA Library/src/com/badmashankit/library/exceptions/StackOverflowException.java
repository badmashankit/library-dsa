package com.badmashankit.library.exceptions;

@SuppressWarnings("serial")
public class StackOverflowException extends RuntimeException {
	public StackOverflowException() {
		super("Stack is Full");
	}
}
