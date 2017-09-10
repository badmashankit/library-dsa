package com.badmashankit.library.exceptions;

@SuppressWarnings("serial")
public class EmptyStackException extends RuntimeException {
	public EmptyStackException() {
		super("Stack is Empty");
	}
}
