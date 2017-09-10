package com.badmashankit.library.exceptions;

@SuppressWarnings("serial")
public class EmptyLinkedListException extends RuntimeException {
	public EmptyLinkedListException() {
		super("Linked List is Empty");
	}
}
